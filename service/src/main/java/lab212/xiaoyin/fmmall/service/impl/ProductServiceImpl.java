package lab212.xiaoyin.fmmall.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab212.xiaoyin.fmmall.entity.*;
import lab212.xiaoyin.fmmall.dao.ProductImgMapper;
import lab212.xiaoyin.fmmall.dao.ProductMapper;
import lab212.xiaoyin.fmmall.dao.ProductParamsMapper;
import lab212.xiaoyin.fmmall.dao.ProductSkuMapper;
import lab212.xiaoyin.fmmall.service.ProductService;
import lab212.xiaoyin.fmmall.utils.PageHelper;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductParamsMapper productParamsMapper;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVO getProductBasicInfo(String productId) {
        //1.??????????????????
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        //?????????1??????????????????
        criteria.andEqualTo("productStatus", 1);
        List<Product> products = productMapper.selectByExample(example);
        if (products.size() > 0) {
            //2.????????????
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId", productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
            //3.????????????
            Example example2 = new Example(lab212.xiaoyin.fmmall.beans.ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId", productId);
            criteria2.andEqualTo("status", 1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

            HashMap<String, Object> basicInfo = new HashMap<>();
            basicInfo.put("product", products.get(0));
            basicInfo.put("productImgs", productImgs);
            basicInfo.put("productSkus", productSkus);
            return new ResultVO(ResStatus.OK, "success", basicInfo);
        } else {
            return new ResultVO(ResStatus.NO, "???????????????????????????", null);
        }
    }

    @Override
    public ResultVO getProductParamsById(String productId) {
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if (productParams.size() > 0) {
            return new ResultVO(ResStatus.OK, "success", productParams.get(0));
        } else {
            return new ResultVO(ResStatus.NO, "??????????????????????????????", null);
        }
    }

    @Override
    public ResultVO getProductsByCategoryId(int categoryId, int pageNum, int limit) {
        //1.??????????????????
        int start = (pageNum - 1) * limit;
        List<ProductVO> productVOS = productMapper.selectProductByCategoryId(categoryId, start, limit);
        //2.?????????????????????????????????????????????
        Example example = new Example(lab212.xiaoyin.fmmall.beans.Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId", categoryId);
        int count = productMapper.selectCountByExample(example);
        //3.???????????????
        int pageCount = count % limit == 0 ? count / limit : count / limit + 1;
        //4.??????????????????
        PageHelper<ProductVO> pageHelper = new PageHelper<>(count, pageCount, productVOS);
        return new ResultVO(ResStatus.OK, "SUCCESS", pageHelper);
    }

    @Override
    public ResultVO listBrands(int categoryId) {
        List<String> brands = productMapper.selectBrandByCategoryId(categoryId);
        return new ResultVO(ResStatus.OK, "success", brands);
    }

    @Override
    public ResultVO searchProduct(String kw, int pageNum, int limit) {
        ResultVO resultVO = null;
        try {
            int start = (pageNum - 1) * limit;
            //Es??????
            SearchRequest searchRequest = new SearchRequest("fmmall_products_index");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(kw, "productName", "productSkuName"));
            searchSourceBuilder.from(start);
            searchSourceBuilder.size(limit);

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            HighlightBuilder.Field field = new HighlightBuilder.Field("productName");
            HighlightBuilder.Field field2 = new HighlightBuilder.Field("productName");
            highlightBuilder.field(field);
            highlightBuilder.field(field2);
            highlightBuilder.preTags("<label style='color:red'>");
            highlightBuilder.postTags("</label>");
            searchSourceBuilder.highlighter(highlightBuilder);

            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            //??????????????????
            SearchHits hits = searchResponse.getHits();
            //????????????
            int count = (int) hits.getTotalHits().value;
            //3.???????????????
            int pageCount = count % limit == 0 ? count / limit : count / limit + 1;
            Iterator<SearchHit> iterator = hits.iterator();
            List<Product4Es> products = new ArrayList<Product4Es>();
            while (iterator.hasNext()) {
                SearchHit searchHit = iterator.next();
                String product4EsStr = searchHit.getSourceAsString();
                Product4Es product4Es = objectMapper.readValue(product4EsStr, Product4Es.class);
                //??????????????????
                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                HighlightField productNameField = highlightFields.get("productName");
                if (productNameField != null) {
                    String highlightProductName = Arrays.toString(productNameField.getFragments());
                }
                HighlightField productSkuNameField = highlightFields.get("productSkuName");
                products.add(product4Es);
            }

            //4.?????????????????????
            PageHelper<Product4Es> pageHelper = new PageHelper<>(count, pageCount, products);
            resultVO = new ResultVO(ResStatus.OK, "SUCCESS", pageHelper);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    @Override
    public ResultVO listBrands(String kw) {
        kw = "%" + kw + "%";
        List<String> brands = productMapper.selectBrandByKeyword(kw);
        return new ResultVO(ResStatus.OK, "SUCCESS", brands);
    }
}

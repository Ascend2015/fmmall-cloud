package lab212.xiaoyin.fmmall.service;


import lab212.xiaoyin.fmmall.entity.ShoppingCart;
import lab212.xiaoyin.fmmall.vo.ResultVO;

public interface ShoppingCartService {

    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateCartNum(int cartId,int cartNum);

    public ResultVO listShoppingCartsByCids(String cids);

}

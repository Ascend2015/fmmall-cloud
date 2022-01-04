package lab212.xiaoyin.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 01:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product4Es {

    private String productId;

    private String productName;

    private String productImg;

    private String productSkuName;

    private double productSkuPrice;

    private int soldNum;
}

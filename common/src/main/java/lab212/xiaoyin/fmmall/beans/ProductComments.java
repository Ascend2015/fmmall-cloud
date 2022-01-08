package lab212.xiaoyin.fmmall.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComments {

    private String commId;

    private String productId;

    private String productName;

    private String orderItemId;

    private String userId;

    private Integer isAnonymous;

    private Integer commType;

    private Integer commLevel;

    private String commContent;

    private String commImgs;

    private Date sepcName;

    private Integer replyStatus;

    private String replyContent;

    private Date replyTime;

    private Integer isShow;

}
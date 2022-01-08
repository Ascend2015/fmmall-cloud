package lab212.xiaoyin.fmmall.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinck
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginHistory {
    /**
     * ID
     */
    private Integer id;

    /**
     * 地区
     */
    private String area;

    /**
     * 国家
     */
    private String country;

    /**
     * 用户id
     */
    private String userId;

    /**
     * IP
     */
    private String ip;

    /**
     * 时间
     */
    private String loginTime;
}
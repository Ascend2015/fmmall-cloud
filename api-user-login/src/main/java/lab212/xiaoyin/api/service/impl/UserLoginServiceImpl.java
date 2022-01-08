package lab212.xiaoyin.api.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lab212.xiaoyin.api.service.UserLoginService;
import lab212.xiaoyin.api.service.feign.UserCheckClient;
import lab212.xiaoyin.fmmall.beans.Users;
import lab212.xiaoyin.fmmall.utils.MD5Utils;
import lab212.xiaoyin.fmmall.vo.ResStatus;
import lab212.xiaoyin.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 20:33
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserCheckClient userCheckClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResultVO checkLogin(String name, String pwd) {
        Users user = userCheckClient.check(name);
        if (user == null) {
            return new ResultVO(10001, "login failed", null);
        } else {
            String md5Pwd = MD5Utils.md5(pwd);
            if (md5Pwd.equals(user.getPassword())) {
                //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
                //使用jwt规则生成token字符串
                JwtBuilder builder = Jwts.builder();


                String token = builder.setSubject(name)
                        //主题，就是token中携带的数据
                        .setIssuedAt(new Date())
                        //设置token的生成时间
                        .setId(user.getUserId() + "")
                        //设置用户id为token  id
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "QIANfeng6666")
                        //设置加密方式和加密密码
                        .compact();
                try {
                    String userInfo = objectMapper.writeValueAsString(user);
                    stringRedisTemplate.boundValueOps(token).set(userInfo, 30, TimeUnit.MINUTES);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                return new ResultVO(ResStatus.OK, token, user);
            } else {
                return new ResultVO(ResStatus.NO, "登录失败，密码错误！", null);
            }
        }
    }
}

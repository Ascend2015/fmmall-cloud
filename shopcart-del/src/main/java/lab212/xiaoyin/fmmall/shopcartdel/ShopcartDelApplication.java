package lab212.xiaoyin.fmmall.shopcartdel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinck
 */
@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.shopcartdel.dao")
@SpringBootApplication
public class ShopcartDelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopcartDelApplication.class, args);
    }

}

package lab212.xiaoyin.fmmall.timeoutquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinck
 */
@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.timeoutquery.dao")
@SpringBootApplication
public class OrderTimeoutQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTimeoutQueryApplication.class, args);
    }

}

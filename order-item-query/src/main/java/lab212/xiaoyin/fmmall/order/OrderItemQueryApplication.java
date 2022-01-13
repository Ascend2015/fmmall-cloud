package lab212.xiaoyin.fmmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinck
 */
@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.order.dao")
@SpringBootApplication
public class OrderItemQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderItemQueryApplication.class, args);
    }

}

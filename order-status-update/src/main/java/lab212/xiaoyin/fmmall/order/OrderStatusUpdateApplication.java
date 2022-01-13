package lab212.xiaoyin.fmmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.order.dao")
@SpringBootApplication
public class OrderStatusUpdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderStatusUpdateApplication.class, args);
    }

}

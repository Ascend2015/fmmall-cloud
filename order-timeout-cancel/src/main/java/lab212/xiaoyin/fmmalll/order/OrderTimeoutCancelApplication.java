package lab212.xiaoyin.fmmalll.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yinck
 */
@EnableScheduling
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class OrderTimeoutCancelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTimeoutCancelApplication.class, args);
    }

}

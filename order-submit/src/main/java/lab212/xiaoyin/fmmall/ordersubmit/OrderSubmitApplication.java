package lab212.xiaoyin.fmmall.ordersubmit;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yinck
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
@EnableDistributedTransaction
public class OrderSubmitApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSubmitApplication.class, args);
    }

}

package lab212.xiaoyin.fmmall.orderitemadd;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.orderitemadd.dao")
@SpringBootApplication
@EnableDistributedTransaction
public class OrderitemAddApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderitemAddApplication.class, args);
    }

}

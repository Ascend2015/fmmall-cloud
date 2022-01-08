package lab212.xiaoyin.fmmall.stockupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinck
 */
@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.stockupdate.dao")
@SpringBootApplication
public class StockUpdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockUpdateApplication.class, args);
    }

}

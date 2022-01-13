package lab212.xiaoyin.fmmall.product.sku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@MapperScan("lab212.xiaoyin.fmmall.product.sku.dao")
@SpringBootApplication
public class ProductSkuQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSkuQueryApplication.class, args);
    }

}

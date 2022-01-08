package lab212.xiaoyin.fmmall.usersave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yinck
 */
@MapperScan("lab212.xiaoyin.fmmall.usersave.dao")
@EnableEurekaClient
@SpringBootApplication
public class UserSaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSaveApplication.class, args);
    }

}

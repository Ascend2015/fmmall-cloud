package lab212.xiaoyin.fmmall.service.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-03 00:35
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.addr.singleAddr.host}")
    private String host;

//    @Value("${redisson.addr.singleAddr.password}")
//    private String password;

    @Value("${redisson.addr.singleAddr.database}")
    private int database;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(host).setDatabase(database);
        return Redisson.create(config);
    }
}

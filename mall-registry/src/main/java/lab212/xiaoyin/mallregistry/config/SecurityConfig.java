package lab212.xiaoyin.mallregistry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-04 16:50
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //设置当前服务器所有请求都需要经过spring security认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}

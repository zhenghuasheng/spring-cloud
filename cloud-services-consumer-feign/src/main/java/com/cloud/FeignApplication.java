package com.cloud;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhenghuasheng on 2017/4/13.17:04
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {


    /**
     * 此方法主要配置登录 Eureka 服务器的帐号与密码。
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin");
    }


    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}

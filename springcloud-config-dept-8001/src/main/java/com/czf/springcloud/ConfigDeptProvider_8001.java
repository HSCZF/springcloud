package com.czf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient     // 开启Eureka客户端，在服务启动后自动注册到Eureka中
@EnableDiscoveryClient  // 开启服务发现
public class ConfigDeptProvider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigDeptProvider_8001.class, args);
    }



}

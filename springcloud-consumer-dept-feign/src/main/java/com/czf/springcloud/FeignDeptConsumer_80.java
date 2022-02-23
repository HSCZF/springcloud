package com.czf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
 * @EnableEurekaClient 启动Eureka客户端
 * 不能直接用@ComponentScan("com.czf.springcloud.service")，因为原因是因为FeignDeptConsumer_80启动类使用了@SpringBootApplication和@ComponentScan("com.czf.springcloud.service"),
 * 当只有一个ComponentScan的时候，SpringBootApplication是不会被加载的.但是如果取消的话，在后面的降级处理P15加入feign:配置的时候，服务将无法启动。解决办法是使用@ComponentScans({@ComponentScan("com.leon.springcloud.service")})
 * 代替componentScan这种方法可以让@SpringBootApplication 和 多个 @ComponentScan("com.leon.springcloud.service") 共存。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.czf.springcloud"})
@ComponentScans({@ComponentScan("com.czf.springcloud.service")})  // 扫描注解加入到spring中
public class FeignDeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }

}

package com.czf.springcloud;

import com.czf.myrule.CzfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
 * @EnableEurekaClient 启动Eureka客户端
 * @RibbonClient：name为微服务的名字,CzfRule不在同一级，要指定。在微服务启动的时候去加载我们自定义的Ribbon类（指定在com.czf.myrule.CzfRule下）
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = CzfRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }

}

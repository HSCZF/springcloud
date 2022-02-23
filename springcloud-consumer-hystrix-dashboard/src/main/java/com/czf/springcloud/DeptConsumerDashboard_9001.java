package com.czf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @EnableHystrixDashboard : 开启监控信息，provider提供者必须在pom.xml配置actuator，完善监控信息
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboard_9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_9001.class, args);
    }

}

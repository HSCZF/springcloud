package com.czf.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient     // 开启Eureka客户端，在服务启动后自动注册到Eureka中
@EnableDiscoveryClient  // 开启服务发现
@EnableCircuitBreaker   // 添加对熔断的支持
public class DeptProviderHystrix_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    /**
     * 增加一个 Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean HystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        // http://localhost:9001/hystrix，把页面显示的最后一部分路径拿过来就可以了
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }

}

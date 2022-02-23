package com.czf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    /**
     * 配置负载均衡实现RestTemplate
     * @LoadBalanced: Ribbon注解
     * IRule
     * RoundRobinRule 轮循
     * RandomRule     随机
     * RetryRule      会先按照轮循获取服务，如果服务获取失败，则会在指定的时间内进行，重试
     * AvailabilityFilteringRule : 会先过滤掉，跳闸，访问故障的服务，对剩下的服务进行轮询
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}

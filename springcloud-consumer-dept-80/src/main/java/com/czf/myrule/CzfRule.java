package com.czf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CzfRule {

    /**
     * 自定义轮循的规则
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}

package com.czf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  // 启动Zuul
public class ZuulApplication_9527 {

    /**
     * 在C盘下的hosts文件配置 127.0.0.1 www.czf.com
     * 在zuul网关访问：    http://www.czf.com:9527/springcloud-provider-dept/dept/get/1
     * yml配置了路由后访问：http://www.czf.com:9527/mydept/dept/get/1
     * 配置ignored-services后，原路径不能访问，忽略掉了，这样就隐藏了源路径
     * 配置前缀后访问：     http://www.czf.com:9527/czf/mydept/dept/get/1
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }

}

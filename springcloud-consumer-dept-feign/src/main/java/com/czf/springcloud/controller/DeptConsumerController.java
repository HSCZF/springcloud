package com.czf.springcloud.controller;

import com.czf.springcloud.pojo.Dept;
import com.czf.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    // 消费者，不应该有service层
    // RestTemplate  直接调用即可，注册到spring中
    // 参数：(url, 实体, Class<T>) responseType

    @Autowired
    private RestTemplate restTemplate;  // 提供多张便捷访问远程http服务的方法，简单称Restful服务模板

    // Ribbon。这里的地址，应该是一个变量，通过服务名来访问。Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
    // 例如：http://localhost/consumer/dept/get/1 这样访问id为1的部门信息
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 这个名称要和springcloud-provider-dept-8001中spring.application.name=springcloud-provider-dept一样  # 3个服务名称要一致
    // private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    // 这个是写死的，现在配置了Feign，用注入的方式
    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
//        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return this.service.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return this.service.queryAll();
    }



}

package com.wolf.cloud.feign;

import com.wolf.cloud.pojo.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "microservice-item") // 申明这是一个Feign客户端，并且指明服务id
public interface ItemFeignClient {

    // 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful的调用了
    @GetMapping("/item/{id}")
    public Item queryItemById(@PathVariable("id") Long id);

}

package com.wolf.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wolf.cloud.feign.ItemFeignClient;
import com.wolf.cloud.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemFeignClient itemFeignClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    public Item queryItemById(Long id) {
//        String serviceId = "microservice-item";
//        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//        if(instances.isEmpty()){
//            return null;
//        }
//        // 为了演示，在这里只获取一个实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
//    }

    /**
     * 调用商品的微服务提供接口进行查询数据
     *
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
//    public Item queryItemById(Long id) {
//        String serviceId = "microservice-item";
//        return this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);
//    }

    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
    public Item queryItemById(Long id) {
        String serviceId = "microservice-item";
        return this.itemFeignClient.queryItemById(id);
    }

    public Item queryItemByIdFallbackMethod(Long id){ // 请求失败执行的方法
        return new Item(id, "查询商品信息出错!", null, null, null);
    }

}
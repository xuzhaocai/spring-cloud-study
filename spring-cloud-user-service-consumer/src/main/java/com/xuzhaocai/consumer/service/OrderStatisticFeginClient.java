package com.xuzhaocai.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// 这里这个name 需要填写 请求的服务提供者的注册到Eureka Server上面的服务名
@FeignClient(name = "spring-cloud-order-service-provider",path = "/order/data",fallback = OrderStatisticFeginClientFallback.class)
//@RequestMapping("/order/data")// 这里你服务提供者接口controller 啥样 可以照着搬过来，当然也可以写到FeignClient注解的path属性上。
public interface OrderStatisticFeginClient {



    // 请求路径，FeginClient增加了对Springmvc的支持，所以可以直接将服务提供者接口controller 方法搬过来，然后去掉方法体
    @GetMapping("/getTodayFinishOrderNum/{id}")
    public Integer getTodayFinishOrderNum(@PathVariable("id") Integer id);

}

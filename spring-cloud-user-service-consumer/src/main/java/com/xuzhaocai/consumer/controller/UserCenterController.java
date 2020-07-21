package com.xuzhaocai.consumer.controller;



import com.xuzhaocai.consumer.service.OrderStatisticFeginClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/user/data")
public class UserCenterController {
    @Autowired
    private OrderStatisticFeginClient orderStatisticFeginClient;
    @GetMapping("/getTodayStatistic/{id}")
    public Integer getTodayStatistic(@PathVariable("id") Integer id){
        Integer todayFinishOrderNum = orderStatisticFeginClient.getTodayFinishOrderNum(id);
        return todayFinishOrderNum;
    }
}


   /*



    @Autowired
    private RestTemplate restTemplate;


   @GetMapping("/getTodayStatistic/{id}")
    @HystrixCommand(
            // 线程池标识
            threadPoolKey = "getTodayStatistic",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "3"),  // 这个就是咱们那个线程池core线程核心数
                    @HystrixProperty(name="maxQueueSize",value="100") //这个是队列大小
            },
            fallbackMethod = "getTodayStatisticFallback",// 服务降级方法

            // 使用commandProperties 可以配置熔断的一些细节信息
            commandProperties = {

                    // 类似kv形式
                    //这里这个参数意思是熔断超时时间2s，表示过了多长时间还没结束就进行熔断
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            }
    )
    public Integer getTodayStatistic(@PathVariable("id") Integer id){
        String url  ="http://spring-cloud-order-service-provider/order/data/getTodayFinishOrderNum/"+id;
        return restTemplate.getForObject(url, Integer.class);
    }
    // 服务降级方法 ，这里参数与返回值需要原方法保持一直
    public Integer getTodayStatisticFallback(Integer id){
        return -1;
    }
    @GetMapping("/getTodayStatisticA/{id}")
    @HystrixCommand(
            // 线程池标识
            threadPoolKey = "getTodayStatisticA",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "2"),  // 这个就是咱们那个线程池core线程核心数
                    @HystrixProperty(name="maxQueueSize",value="100") //这个是队列大小
            },
            fallbackMethod = "getTodayStatisticFallbackA",// 服务降级方法

            // 使用commandProperties 可以配置熔断的一些细节信息
            commandProperties = {

                    // 类似kv形式
                    //这里这个参数意思是熔断超时时间2s，表示过了多长时间还没结束就进行熔断
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            }
    )
    public Integer getTodayStatisticA(@PathVariable("id") Integer id){
        String url  ="http://spring-cloud-order-service-provider/order/data/getTodayFinishOrderNum/"+id;
        return restTemplate.getForObject(url, Integer.class);
    }
    // 服务降级方法 ，这里参数与返回值需要原方法保持一直
    public Integer getTodayStatisticFallbackA(Integer id){
        return -1;
    }





    @GetMapping("/getTodayStatisticB/{id}")
    @HystrixCommand(
            // 线程池标识
            threadPoolKey = "getTodayStatisticB",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "1"),  // 这个就是咱们那个线程池core线程核心数
                    @HystrixProperty(name="maxQueueSize",value="100") //这个是队列大小
            },
            fallbackMethod = "getTodayStatisticFallbackB",// 服务降级方法
            // 使用commandProperties 可以配置熔断的一些细节信息
            commandProperties = {
                    // 类似kv形式
                    //这里这个参数意思是熔断超时时间2s，表示过了多长时间还没结束就进行熔断
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500"),
                    // 当遇到失败后，开启一个15s的窗口
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "15000"),
                    // 最小请求数 5
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
                    // 失败次数占请求的50%
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 跳闸后 活动窗口配置 这里配置了10s
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
            }

    )
    public Integer getTodayStatisticB(@PathVariable("id") Integer id){
        String url  ="http://spring-cloud-order-service-provider/order/data/getTodayFinishOrderNum/"+id;
        return restTemplate.getForObject(url, Integer.class);
    }
    // 服务降级方法 ，这里参数与返回值需要原方法保持一直
    public Integer getTodayStatisticFallbackB(Integer id){
        return -1;
    }
*/


   /*@Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getTodayStatistic/{id}")
    public Integer getTodayStatistic(@PathVariable("id") Integer id){

        // 使用discoveryClient 类能够与eureka server 交互， getInstances 获取注册到eureka server
        // 的"spring-cloud-order-service-provider" 实例列表

        List<ServiceInstance> instances = discoveryClient.getInstances("spring-cloud-order-service-provider");

        // 获取第一个服务信息
        ServiceInstance instanceInfo = instances.get(0);
        //获取ip
        String ip = instanceInfo.getHost();
        //获取port
        int port = instanceInfo.getPort();
        String url  ="http://"+ip+":"+port+"/order/data/getTodayFinishOrderNum/"+id;
        return restTemplate.getForObject(url, Integer.class);
    }*/
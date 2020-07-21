package com.xuzhaocai.provider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/data")
public class OrderStatisticServiceController {
    @Value("${server.port}")
    private Integer port;

    @Value("${spring.application.name}")
    private String appName;
    /**
     * 根据用户id获取今日完单数
     * @param id 用户ID
     * @return  完单数
     */
    @GetMapping("/getTodayFinishOrderNum/{id}")
    public Integer getTodayFinishOrderNum(@PathVariable("id") Integer id){
        System.out.println("我是"+port);
        /*if (port==7070){
            try {// 睡眠10s
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        return port;
    }
    // 获取appName
    @GetMapping("/getAppName/{id}")
    public String  getAppName(@PathVariable("id") Integer id){

        // appName +port
        return appName+String.valueOf(port);
    }
}

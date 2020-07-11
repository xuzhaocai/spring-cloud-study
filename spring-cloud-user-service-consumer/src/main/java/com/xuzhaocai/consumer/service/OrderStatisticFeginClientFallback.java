package com.xuzhaocai.consumer.service;

import com.xuzhaocai.consumer.service.OrderStatisticFeginClient;
import org.springframework.stereotype.Component;


@Component  // 将该fallback类交由给Spring管理
public class OrderStatisticFeginClientFallback  implements OrderStatisticFeginClient {

    // fallback 处理逻辑
    @Override
    public Integer getTodayFinishOrderNum(Integer id) {
        return -1;
    }
}

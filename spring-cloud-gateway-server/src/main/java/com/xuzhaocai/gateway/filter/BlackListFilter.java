package com.xuzhaocai.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


//@Component
public class BlackListFilter  implements GlobalFilter, Ordered {

    // 这里模拟下黑名单
    private static final List<String>  blackList=new ArrayList<>();
    static {

        blackList.add("127.0.0.1");// 模拟本机地址
    }
    /**
     * 进行过滤操作
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 获取请求
        ServerHttpRequest request = exchange.getRequest();

        // 获取响应
        ServerHttpResponse response = exchange.getResponse();
        // 获取客户端ip
        String host = request.getRemoteAddress().getHostString();
        System.out.println("remote host:"+host);
        if (blackList.contains(host)){  // 这个客户端ip在黑名单里面
            // 设置响应码
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            String data = "拒绝访问";
            DataBuffer wrap = response.bufferFactory().wrap(data.getBytes());
            HttpHeaders headers = response.getHeaders();
            // 设置中文乱码
            headers.add("content-type", "text/html;charset=utf-8");
            return response.writeWith(Mono.just(wrap));
        }
        // 放行到下一个过滤器
        return chain.filter(exchange);
    }

    /**
     * 主要是多个过滤器的时候，需要对过滤器排序，
     * 先经过哪个，后经过哪个,数值越小，这个优先级越高
     * @return order优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}

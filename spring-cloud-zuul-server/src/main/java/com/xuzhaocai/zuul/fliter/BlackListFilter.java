package com.xuzhaocai.zuul.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class BlackListFilter extends ZuulFilter {


    private static List<String> blackList;



    static {

        // 模拟黑名单
        blackList=new ArrayList<>();
        blackList.add("127.0.0.1");
    }


    // filter 类型
    @Override
    public String filterType() {
        return "pre";
    }
    // filter排序
    @Override
    public int filterOrder() {
        return 0;
    }
    // 是否启用filter
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {


        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();
        String remoteHost = request.getRemoteHost();

        if (blackList.contains(remoteHost)){
            currentContext.set("isSuccess", false);
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("非法请求");
            currentContext.getResponse().setContentType("application/json; charset=utf-8");
        }

        return null;
    }
}

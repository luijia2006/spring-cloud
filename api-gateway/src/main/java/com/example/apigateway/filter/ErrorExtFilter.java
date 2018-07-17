package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorExtFilter extends SendErrorFilter
{
    private static final Logger logger = LoggerFactory.getLogger(ErrorExtFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;//大于ErrorFilter的值
    }

    @Override
    public boolean shouldFilter() {
        //TODO判断：仅处理来自post过滤器引起的异常
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter)ctx.get("failed.filter");
        if (failedFilter!=null&&failedFilter.filterType().equals("post")) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        logger.error("this is errorFilter:{}",throwable.getCause().getMessage());
        ctx.set("error.status_code",
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());
        return null;
    }
}

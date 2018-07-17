package com.example.apigateway.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 扩展processZuulFilter
 * 当过滤器执行抛出异常的时候，我们捕获它，并且请求上下文记录一些信息
 */
public class DidiFilterProcessor extends FilterProcessor
{
    private static final Logger logger = LoggerFactory.getLogger(DidiFilterProcessor.class);
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException{
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext currentContext = RequestContext.getCurrentContext();
            currentContext.set("failed.filter",filter);
            throw e;
        }
    }
}

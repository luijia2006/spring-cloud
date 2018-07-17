package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ThrowExceptionFilter extends ZuulFilter
{
    private static final Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("this is pre filter,it will throw a RuntimeException!");
        RequestContext ctx = RequestContext.getCurrentContext();
        //try {
            doSomething();
        /*} catch (Exception e) {
            ctx.set("error.status_code",
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
        }*/
        return null;
    }
    public void doSomething() {
        throw new RuntimeException("exist some errors...");
    }
}

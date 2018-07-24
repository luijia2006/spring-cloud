import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PreFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("你好啊 this is a pre filter: Send ");
        return null;
    }
}
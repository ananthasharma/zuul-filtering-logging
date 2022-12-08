package com.anantha.apps.zuul_filter_logging.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author Anantha Sharma
 * @created 08-Dec-2022 - 18:21
 */
@Component
public class ZuulRequestLoggingFilter extends ZuulFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ZuulRequestLoggingFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        var callFor = RequestContext.getCurrentContext().getRequest().getRequestURI();
        LOG.info("call for: {}", callFor);
        return null;
    }
}

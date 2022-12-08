package com.anantha.apps.zuul_filter_logging.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author Anantha Sharma
 * @created 08-Dec-2022 - 18:21
 */
public class ZuulLoggingFilter extends ZuulFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ZuulLoggingFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
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

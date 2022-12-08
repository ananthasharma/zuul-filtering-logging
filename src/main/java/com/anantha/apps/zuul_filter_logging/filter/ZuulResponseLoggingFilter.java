package com.anantha.apps.zuul_filter_logging.filter;

import com.anantha.apps.zuul_filter_logging.constants.Utils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;


/**
 * @author Anantha Sharma
 * @created 08-Dec-2022 - 18:21
 */
@Component
public class ZuulResponseLoggingFilter extends ZuulFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ZuulResponseLoggingFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        long startMillis = Utils.getStartTimeFromRequestHeader();
        long endMillis = System.currentTimeMillis();
        var duration = endMillis - startMillis;
        var durationAsString = DurationFormatUtils.formatDuration(duration, "HH:mm:ss.SSS");
        LOG.info("response for: {}, duration(HH:mm:ss.SSS): {}", callFor, durationAsString);
        return null;
    }

}

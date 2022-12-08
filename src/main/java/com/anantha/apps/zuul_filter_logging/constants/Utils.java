package com.anantha.apps.zuul_filter_logging.constants;

import com.netflix.zuul.context.RequestContext;

/**
 * @author Anantha Sharma
 * @created 08-Dec-2022 - 20:01
 */
public class Utils {
    /**
     * get current time as String
     * @return
     */
    public static String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * get current time or startTime of the request
     * @return
     */
    public static Long getStartTimeFromRequestHeader(){
        var requestHeaders= RequestContext.getCurrentContext().getZuulRequestHeaders();
        var currTime = String.valueOf(System.currentTimeMillis());
        return Long.valueOf(requestHeaders.getOrDefault(Constants.START_TIME_HEADER, currTime));
    }
}

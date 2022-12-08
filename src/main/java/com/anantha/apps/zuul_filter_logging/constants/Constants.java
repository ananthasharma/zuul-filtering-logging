package com.anantha.apps.zuul_filter_logging.constants;

import java.util.UUID;

/**
 * @author Anantha Sharma
 * @created 08-Dec-2022 - 18:40
 */
public class Constants {
    /**
     * header key for start time,
     * it can be anything (preferably something meaningful, but a random value should be fine)
     */
    public static final String START_TIME_HEADER= UUID.randomUUID().toString();
    /**
     * key to track user Id
     */
    public static final String USER_ID= UUID.randomUUID().toString();
}

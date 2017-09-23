package com.jack.config;

import com.jack.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/23.
 *
 * @author liweijian.
 */
public class GlobalConfig {

    private static final Logger logger = LoggerFactory.getLogger(GlobalConfig.class);

    private static final String PROFILE;

    private static final String ONLINE = "online";

    static {
        PROFILE = lookupKey("spring.profiles.active");
    }

    public static String lookupKey(String key) {
        String profile = System.getProperty(key);
        if (StringUtils.isEmpty(profile)) {
            profile = System.getenv(key);
        }
        Environment environment = SpringContextUtils.getBeanByType(Environment.class);
        profile = environment.getActiveProfiles()[0];
        logger.info("-------------current profile---------------: {}", profile);
        return profile;
    }

    public static String getProfile() {
        return PROFILE;
    }

    public static boolean isOnline() {
        return Objects.equals(PROFILE, ONLINE);
    }
}
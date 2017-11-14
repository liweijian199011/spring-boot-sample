package com.jack.util;

import com.jack.mapper.GlobalMapper;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/23.
 *
 * @author liweijian.
 */
public class HostnameUtils {

    public static String getHostname() {
        return SpringUtils.getBean(GlobalMapper.class).selectHostname();
    }
}
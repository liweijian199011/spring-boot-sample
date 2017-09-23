package com.jack.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/23.
 *
 * @author liweijian.
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);

    public static <T> T getBean(String name, Class<T> clazz) {
        T t = null;

        //优先按照名称获取， 名称获取不到再按照类型获取
        try {
            t = Holder.applicationContext.getBean(name, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage(), e);
        }

        if (t == null) {
            try {
                t = getBeanByType(clazz);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info(e.getMessage(), e);
            }
        }
        if (t == null) {
            logger.error("can not found required bean !",
                    new BeanCreationException(new StringBuffer("can not find bean [ ").append(name).append(" ] ! ").toString()));
        }

        return t;
    }

    public static <T> T getBeanByType(Class<T> clazz) {
        T t = Holder.applicationContext.getBean(clazz);
        if (t == null) {
            logger.error("can not found required bean !",
                    new BeanCreationException(new StringBuffer("can not find bean by type [ ").append(clazz.getName()).append(" ] ! ").toString()));
        }
        return t;
    }

    @Override
    public void setApplicationContext(ApplicationContext contexts)
            throws BeansException {
        Holder.setApplicationContext(contexts);
        logger.info("set application context complete !");
    }

    private static class Holder {
        private static ApplicationContext applicationContext;

        private static void setApplicationContext(ApplicationContext context) {
            Holder.applicationContext = context;
        }
    }

}

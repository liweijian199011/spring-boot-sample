package com.example.demo.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/12/5.
 *
 * @author liweijian.
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Bean
    @ConditionalOnMissingBean
    public DemoService demoService() {
        return new DemoService(demoProperties.getPrefix(),demoProperties.getSuffix());
    }
}

package com.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description
 * <p>
 *     自定义metrics度量值，每一个Metrics都是一个度量值的key-value
 * </p>
 * DATE 2017/12/20.
 *
 * @author liweijian.
 */
@Component
public class ApplicationContextMetrics implements PublicMetrics {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrics = new ArrayList<>();
        metrics.add(new Metric<Long>("spring.context.startup-date", applicationContext.getStartupDate()));
        metrics.add(new Metric<Integer>("spring.beans.definitions", applicationContext.getBeanDefinitionCount()));
        metrics.add(new Metric<Integer>("spring.beans", applicationContext.getBeanNamesForType(Object.class).length));
        metrics.add(new Metric<Integer>("spring.controllers", applicationContext.getBeanNamesForAnnotation(Controller.class).length));
        return metrics;
    }
}

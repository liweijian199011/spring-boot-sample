package com.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * <p>
 *     自定义health指标
 * </p>
 * DATE 2017/12/19.
 *
 * @author liweijian.
 */
@Component
public class JackHealthIndicator implements HealthIndicator {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Health health() {
        HttpStatus status;
        try {
            status = restTemplate.getForEntity("http://localhost:8761/eureka/apps", Object.class).getStatusCode();
        } catch (Exception ex) {
            Status healthStatus = new Status("EXCEPTION", "异常");
            // 自定义health status
            Health health = Health.status(healthStatus).withDetail("reason", ex.getMessage()).build();
//            Health health = Health.down().withDetail("reason", ex.getMessage()).build();
            return health;
        }
        if (status.is2xxSuccessful()) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }
}

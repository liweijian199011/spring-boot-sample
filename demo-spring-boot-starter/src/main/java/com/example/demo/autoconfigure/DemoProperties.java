package com.example.demo.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/12/5.
 *
 * @author liweijian.
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private String prefix = "default-prefix-";

    private String suffix = "-default-suffix";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

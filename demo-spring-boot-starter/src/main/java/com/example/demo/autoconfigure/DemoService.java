package com.example.demo.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/12/5.
 *
 * @author liweijian.
 */
public class DemoService {

    private String prefix = "";

    private String suffix = "";

    public DemoService() {
    }

    public DemoService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String wrap(String content) {
        return this.prefix + content + this.suffix;
    }
}
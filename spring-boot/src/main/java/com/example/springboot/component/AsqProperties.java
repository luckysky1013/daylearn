package com.example.springboot.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liujian
 * @date 2018/1/15
 */
@Component
public class AsqProperties {
    @Value("${com.asq.title}")
    private String title;

    @Value("${com.asq.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

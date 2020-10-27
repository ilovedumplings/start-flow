package com.shi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author DaTou
 * @Description
 * @Date 2020/10/21
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private String url;

    private String username;

    private String password;

}

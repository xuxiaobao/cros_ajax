package com.cros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/6/2.
 */
@Configuration
@ImportResource(value = "classpath:spring-common.xml")
public class JdbcConfig {
}

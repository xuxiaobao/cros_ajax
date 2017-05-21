package com.cros;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * Created by xxb on 2017/4/25.
 */
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer cnv) {
        cnv.setPort(8020);
    }
}

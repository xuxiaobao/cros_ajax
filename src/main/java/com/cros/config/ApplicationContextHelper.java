package com.cros.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Administrator on 2017/5/24.
 */
//@Component
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext appCtx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }
    public static String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
        return appCtx.getMessage(s, objects, locale);
    }
}

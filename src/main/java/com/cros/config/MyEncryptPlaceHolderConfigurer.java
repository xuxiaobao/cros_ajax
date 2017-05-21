package com.cros.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by Administrator on 2017/5/21.
 */
public class MyEncryptPlaceHolderConfigurer extends PropertyPlaceholderConfigurer {
    private String[] encryptPropName = {"userName", "password"};
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        return super.convertProperty(propertyName, propertyValue);
    }

    private boolean isEncryptProp(String name) {
        for(String encrypt : encryptPropName) {
            if (encrypt.equals(name)) {
                return true;
            }
        }
        return false;
    }
}

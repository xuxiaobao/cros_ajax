package com.cros.controller;

import com.cros.util.Constants;
import com.cros.util.HttpClientUtil;
import com.cros.util.XmlUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by xxb on 2017/5/13.
 */
public class MainController {

    /*public boolean authToken() {
        StringBuilder builder = new StringBuilder();
        String dateTime = dateToString();
        String sign = DigestUtils.sha256Hex(Constants.AppKey.concat(dateTime).concat(Constants.AppSecret));
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<Request>");
        builder.append("<Datetime>").append(dateTime).append("</Datetime>");
        builder.append("<Authorization>");
        builder.append("<AppKey>").append(Constants.AppKey).append("</AppKey>");
        builder.append("<Sign>").append(sign).append("</Sign>");
        builder.append("</Authorization>");
        builder.append("</Request>");
        String s = HttpClientUtil.doPost("https://pdata.4ggogo.com/web-in/auth.html", builder.toString());
        try {
            Map<String, String> map = XmlUtil.xmlToMap(s);
            if (map != null) {
                String expiredTime = map.get("ExpiredTime");
                String token = map.get("Token");
                if (StringUtils.isNotBlank(expiredTime)&&StringUtils.isNotBlank(token)) {
                    Constants.TokenMap.put("Token", token);
                    Constants.TokenMap.put("ExpiredTime", expiredTime);
                    return true;
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return false;
    }*/

    /*public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJmbG93LXBsYXRmb3JtIiwiYXVkIjoiYjM5NWU2NmRlNWQ5NDU4YjhiOGVlZWRkNjAyY2U3ZDM6OjoiLCJleHAiOjE0OTQ2Njk3ODV9.tZQYddPEeIzsnLCMQm3v9DT2_OjriUvodV6XJlQVE9M";
        String sign = DigestUtils.sha256Hex(Constants.AppSecret);
        String s = HttpClientUtil.doGet("https://pdata.4ggogo.com/web-in/products.html",token,sign);
        System.out.println(s);
    }*/

    public static void main(String[] args) {
        String xml = "<Response><Datetime><Datetime>2016-03-19T15:43:33.136+08:00</Datetime></Datetime></Response>";
        try {
            Map<String, String> map = XmlUtil.xmlToMap(xml);
            System.out.println(map);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

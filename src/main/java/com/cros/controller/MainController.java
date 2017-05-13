package com.cros.controller;

import com.cros.util.Constants;
import com.cros.util.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xxb on 2017/5/13.
 */
public class MainController {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        long utc = System.currentTimeMillis()-28800000;
        Date dt = new Date(utc);
       /* String dateTime = dateToString(dt);
        String sign = DigestUtils.sha256Hex(Constants.AppKey.concat(dateTime).concat(Constants.AppSecret));*/
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<Request>");
        builder.append("<Datetime>").append("2016-08-19T16:26:25.367+08:00").append("</Datetime>");
        builder.append("<Authorization>");
        builder.append("<AppKey>").append(Constants.AppKey).append("</AppKey>");
        builder.append("<Sign>").append("58eda4757b56edd2c20c885952fa81da81629ad0cf6f23d3241574effc0396c8").append("</Sign>");
        builder.append("</Authorization>");
        builder.append("</Request>");
        String s = HttpClientUtil.doPost("https://pdata.4ggogo.com/web-in/auth.html", builder.toString());
        System.out.println(s);

    }


    /*public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJmbG93LXBsYXRmb3JtIiwiYXVkIjoiYjM5NWU2NmRlNWQ5NDU4YjhiOGVlZWRkNjAyY2U3ZDM6OjoiLCJleHAiOjE0OTQ2NjQ0NDV9.awWG9pe3QTf73pQefn5WS5V5ywzxQX3ZmwJXWlQdRQjESQao1JHBKTQhZR0H0c5V";
        String s = HttpClientUtil.doGet("https://pdata.4ggogo.com/web-in/products.html",token);
        System.out.println(s);
    }*/
    public static String dateToString(Date dt) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return df.format(dt);
    }
}

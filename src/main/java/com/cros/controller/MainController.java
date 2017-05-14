package com.cros.controller;

import com.cros.util.Constants;
import com.cros.util.DateUtil;
import com.cros.util.HttpClientUtil;
import com.cros.util.XmlUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xxb on 2017/5/13.
 */
@RestController
public class MainController {

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public boolean authToken() {
        StringBuilder builder = new StringBuilder();
        String dateTime = DateUtil.formatDate(new Date());
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
        if (StringUtils.isNotBlank(s)) {
            try {
                Document document = DocumentHelper.parseText(s);
                Element root = document.getRootElement().element("Authorization");
                String token = root.element("Token").getText();
                String expiredTime = root.element("ExpiredTime").getText();
                Constants.TokenMap.put("Token", token);
                Constants.TokenMap.put("ExpiredTime", expiredTime);
                return true;
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private boolean checkToken() {
        String token = Constants.TokenMap.get("Token");
        String expiredTime = Constants.TokenMap.get("ExpiredTime");
        if (StringUtils.isNotBlank(token)) {
            Date dt = DateUtil.parseDate(expiredTime);
            long now = System.currentTimeMillis();
            if (now >= dt.getTime()) {
                if (authToken()) {
                    return true;
                }
            }else {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public Object products() {
        if (!checkToken()) {
            authToken();
        }
        String token = Constants.TokenMap.get("Token");
        String sign = DigestUtils.sha256Hex(Constants.AppSecret);
        String s = HttpClientUtil.doGet("https://pdata.4ggogo.com/web-in/products.html",token,sign);
        Map<String, Object> map = XmlUtil.xmlToMap(s);
        return map;
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public Object charge(String mobile, String productId) {
        if (!checkToken()) {
            authToken();
        }
        StringBuilder builder = new StringBuilder();
        Date dt = new Date();
        String dateTime = DateUtil.formatDate(dt);
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<Request>");
        builder.append("<Datetime>").append(dateTime).append("</Datetime>");
        builder.append("<ChargeData>");
        builder.append("<Mobile>").append(mobile).append("</Mobile>");
        builder.append("<ProductId>").append(productId).append("</ProductId>");
        builder.append("<SerialNum>").append(DateUtil.formatNormalDate(dt)).append("</SerialNum>");
        builder.append("</ChargeData>");
        builder.append("</Request>");
        String param = builder.toString();
        String token = Constants.TokenMap.get("Token");
        String sign = DigestUtils.sha256Hex(param.concat(Constants.AppSecret));
        String s = HttpClientUtil.doPost("https://pdata.4ggogo.com/web-in/boss/charge.html", param, token, sign);
        if (StringUtils.isNotBlank(s)) {
            return XmlUtil.xmlToMap(s);
        }
        return null;
    }

    @RequestMapping(value = "/chargeRecord", method = RequestMethod.GET)
    public Object chargeRecord(String systemNum) {
        if (!checkToken()) {
            authToken();
        }
        String token = Constants.TokenMap.get("Token");
        String sign = DigestUtils.sha256Hex(Constants.AppSecret);
        String url = "https://pdata.4ggogo.com/web-in/chargeRecords/".concat(systemNum).concat(".html");
        String s = HttpClientUtil.doGet(url,token,sign);
        Map<String, Object> map = XmlUtil.xmlToMap(s);
        return map;
    }
}

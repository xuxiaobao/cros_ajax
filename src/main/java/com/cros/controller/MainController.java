package com.cros.controller;

import com.cros.util.Constants;
import com.cros.util.DateUtil;
import com.cros.util.HttpClientUtil;
import com.cros.util.XmlUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xxb on 2017/5/13.
 */
@RestController
public class MainController {

    /*@RequestMapping(value = "/auth", method = RequestMethod.GET)
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
        Map<String, String> result = HttpClientUtil.doPost(Constants.SERVER_URL+"auth.html", builder.toString());
        if (StringUtils.isNotBlank(result.get("response"))) {
            try {
                String response = XmlUtil.replaceBlank(result.get("response"));
                Document document = DocumentHelper.parseText(response);
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
    }*/
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

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/xml");

        String result = HttpClientUtil.doPost(Constants.SERVER_URL+"auth.html", builder.toString(), headers);
        if (StringUtils.isNotBlank(result)) {
            try {
                String response = XmlUtil.replaceBlank(result);
                Document document = DocumentHelper.parseText(response);
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

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public Object charge(String mobile, String productId) throws Exception {
        /*
        鉴权
         */

        if (true) {
            /*
            参数
             */
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
            String param = builder.toString();

            //创建post请求
            HttpPost post = new HttpPost(Constants.SERVER_URL.concat("auth.html"));
            post.setHeader("Content-Type", "application/xml");
            post.setHeader("4GGOGO-Auth-Token", "");
            post.setHeader("HTTP-X-4GGOGO-Signature", "");
            post.setEntity(new StringEntity(param, "UTF-8"));
            String resutString = null;
            try {
                CloseableHttpClient httpClient = HttpClients.custom().build();
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    resutString = EntityUtils.toString(entity);
                    System.out.println("鉴权返回结果："+resutString);

                    resutString = XmlUtil.replaceBlank(resutString);
                    Document document = DocumentHelper.parseText(resutString);
                    Element root = document.getRootElement().element("Authorization");
                    String token = root.element("Token").getText();
                    String expiredTime = root.element("ExpiredTime").getText();
                    Constants.TokenMap.put("Token", token);
                    Constants.TokenMap.put("ExpiredTime", expiredTime);
                }
            } catch (Exception ex) {

            } finally {
                System.out.println("鉴权结束");
            }
        }
        /*
        充值
         */
        String systemNum = null;
        if (true) {
            System.out.println("充值开始");
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


            try {
                HttpPost post = new HttpPost(Constants.SERVER_URL+"boss/charge.html");
                post.setHeader("Content-Type", "application/xml");
                post.setHeader("4GGOGO-Auth-Token", token);
                post.setHeader("HTTP-X-4GGOGO-Signature", sign);
                post.setEntity(new StringEntity(param, "UTF-8"));
                CloseableHttpClient httpClient = HttpClients.custom().build();
                CloseableHttpResponse response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                String resutString = null;
                if (entity != null) {
                    resutString = EntityUtils.toString(entity);
                    System.out.println("充值返回结果是："+resutString);
                    resutString = XmlUtil.replaceBlank(resutString);
                    Document document = DocumentHelper.parseText(resutString);
                    Element chargeData = document.getRootElement().element("ChargeData");
                    systemNum = chargeData.element("SystemNum").getText();
                    if (StringUtils.isEmpty(systemNum)) {
                        new RuntimeException("充值单号为空");
                    }
                }
            } catch (Exception ex) {

            } finally {
                System.out.println("充值结束");
            }
        }
        Thread.sleep(1000);
        /*
        查询结果
         */
        if (true) {
            System.out.println("查询充值结果");
            String status = null;
            String description = null;
            try {
                if (StringUtils.isNotEmpty(systemNum)) {
                    String token = Constants.TokenMap.get("Token");
                    String sign = DigestUtils.sha256Hex(Constants.AppSecret);
                    HttpGet get = new HttpGet(Constants.SERVER_URL+"chargeRecords/"+systemNum+".html");
                    get.setHeader("Content-Type", "application/xml;charset=utf-8");
                    get.setHeader("4GGOGO-Auth-Token", token);
                    get.setHeader("HTTP-X-4GGOGO-Signature", sign);
                    CloseableHttpClient httpClient = HttpClients.custom().build();
                    CloseableHttpResponse response = httpClient.execute(get);
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String resultString = EntityUtils.toString(entity,"UTF-8");
                        System.out.println("查询充值返回结果是："+resultString);
                        resultString = XmlUtil.replaceBlank(resultString);
                        Document document = DocumentHelper.parseText(resultString);
                        Element record = document.getRootElement().element("Records").element("Record");
                        status = record.element("Status").getText();
                        //description = record.element("Description").getText();
                    }
                } else {
                    throw new RuntimeException("充值单号为空");
                }
            } catch (Exception ex) {

            } finally {
                System.out.println("查询充值结果结束");
            }
            if (status != null) {
                if ("3".equals(status)) {
                    System.out.println("充值成功");
                } else if ("4".equals(status)) {
                    System.out.println("充值失败");
                } else {
                    System.out.println("订单已创建或已发送请求");
                }
            } else {
                throw new RuntimeException("订单查询充值结果为null");
            }
        }

        return null;
    }
    private boolean checkToken() {
        String token = Constants.TokenMap.get("Token");
        String expiredTime = Constants.TokenMap.get("ExpiredTime");
        if (StringUtils.isNotBlank(token)) {
            Date dt = DateUtil.parseDate(expiredTime);
            long now = System.currentTimeMillis()-1000;
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
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/xml;charset=utf-8");
        headers.put("4GGOGO-Auth-Token", Constants.TokenMap.get("Token"));
        headers.put("HTTP-X-4GGOGO-Signature", DigestUtils.sha256Hex(Constants.AppSecret));
        String result = HttpClientUtil.doGet(Constants.SERVER_URL+"products.html",headers);
        Map<String, Object> map = XmlUtil.xmlToMap(result);
        return map;
    }

    /*@RequestMapping(value = "/charge", method = RequestMethod.POST)
    public Object charge(String mobile, String productId) throws Exception {
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
        Map<String, String> result = HttpClientUtil.doPost(Constants.SERVER_URL+"boss/charge.html", param, token, sign);
        System.out.println(result);

        if (StringUtils.isNotBlank(result.get("response"))) {
            String response = XmlUtil.replaceBlank(result.get("response"));
            System.out.println(response);
            Document document = DocumentHelper.parseText(response);
            String systemNum = document.getRootElement().element("SystemNum").getText();
            sign = DigestUtils.sha256Hex(Constants.AppSecret);
            String url = Constants.SERVER_URL+"chargeRecords/".concat(systemNum).concat(".html");
            Map<String, String> record = HttpClientUtil.doGet(url, token, sign);
            System.out.println(record);
        }

        return null;
    }*/

    @RequestMapping(value = "/chargeRecord", method = RequestMethod.GET)
    public Object chargeRecord(String systemNum) {
        if (!checkToken()) {
            authToken();
        }
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/xml;charset=utf-8");
        headers.put("4GGOGO-Auth-Token", Constants.TokenMap.get("Token"));
        headers.put("HTTP-X-4GGOGO-Signature", DigestUtils.sha256Hex(Constants.AppSecret));
        String url = Constants.SERVER_URL+"chargeRecords/".concat(systemNum).concat(".html");
        String result = HttpClientUtil.doGet(url,headers);
        Map<String, Object> map = XmlUtil.xmlToMap(result);
        return map;
    }

    @RequestMapping(value = "/hlr", method = RequestMethod.GET)
    public Object userHlr(String mobile) {
        if (!checkToken()) {
            authToken();
        }
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/xml;charset=utf-8");
        headers.put("4GGOGO-Auth-Token", Constants.TokenMap.get("Token"));
        headers.put("HTTP-X-4GGOGO-Signature", DigestUtils.sha256Hex(Constants.AppSecret));
        String url = Constants.SERVER_URL+"user/".concat(mobile).concat("hlr");
        String result = HttpClientUtil.doGet(url, headers);
        Map<String, Object> map = XmlUtil.xmlToMap(result);
        System.out.println(result);
        return map;
    }

}

package com.cros.service;

import com.cros.config.WechatConfig;
import com.cros.util.MD5;
import com.cros.util.XML2List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/5/30.
 */
@Service
public class WeiXinRecharge {

    public static void recharge() {

        Random rand=new Random();
        String order_sn = "KT-" + (System.currentTimeMillis())+rand.nextInt(1000);

        //请求地址
        String url ="https://api.mch.weixin.qq.com/pay/unifiedorder";
        String nonce_str =  MD5.getMd5Value(String.valueOf(rand.nextInt()));

        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", WechatConfig.APP_ID);
        map.put("mch_id", WechatConfig.MCH_ID);
        map.put("nonce_str", nonce_str);
        map.put("body", "app-"+order_sn);
        map.put("out_trade_no", order_sn);
        map.put("total_fee", "1");
        map.put("spbill_create_ip", "127.0.0.1");
        map.put("notify_url", "http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        map.put("trade_type", "APP");
        String sign = getSign(map);

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>").append(WechatConfig.APP_ID).append("</appid>");  /*公众账号ID*/
        sb.append("<mch_id>").append(WechatConfig.MCH_ID).append("</mch_id>");         /*商户号*/
        sb.append("<nonce_str>").append(nonce_str).append("</nonce_str>");      /*32位以内随机串*/
        sb.append("<sign>").append(sign).append("</sign>");             /*签名*/
        sb.append("<body>").append("app-"+order_sn).append("</body>");      /*商品描述*/
        sb.append("<out_trade_no>").append(order_sn).append("</out_trade_no>"); /*商户订单号*/
        sb.append("<total_fee>").append("1").append("</total_fee>");        /*标价金额*/
        sb.append("<spbill_create_ip>").append("127.0.0.1").append("</spbill_create_ip>");  /*终端IP*/
        sb.append("<notify_url>").append("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php").append("</notify_url>"); /*通知地址*/
        sb.append("<trade_type>").append("APP").append("</trade_type>");  /*交易类型*/
        sb.append("</xml>");
        String param = sb.toString();
        System.out.println(param);

        String resutString = null;
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Content-type", "application/json;charset=utf-8");
            post.setEntity(new StringEntity(param, "gbk"));
            CloseableHttpClient httpClient = HttpClients.custom().build();
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                resutString = EntityUtils.toString(entity, "UTF-8");
                System.out.println("充值返回结果是："+resutString);
            }
        } catch (Exception ex) {

        } finally {
            System.out.println("充值结束");
        }

        Map order = new HashMap();
        order = new XML2List().parseToMap(resutString);
        System.out.println(order.get("return_msg").toString());
    }

    public static String getSign(Map<String, String> map) {
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String,String> entry: list) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.append("key=").append(WechatConfig.KEY);
        System.out.println(sb.toString());
        String sign = MD5.getMd5Value(sb.toString()).toUpperCase();
        System.out.println("sign="+sign);
        return sign;
    }

    public static void main(String[] args) throws DocumentException {
        //recharge();

        /*<xml>
            <return_code><![CDATA[SUCCESS]]></return_code>
        </xml>*/
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>").append("<return_code><![CDATA[SUCCESS]]></return_code>").append("</xml>");
        Document document = DocumentHelper.parseText(sb.toString());
        String return_code = document.getRootElement().element("return_code").getText();
        System.out.println(return_code);

    }
}

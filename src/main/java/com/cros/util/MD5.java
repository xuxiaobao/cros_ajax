package com.cros.util;

import java.security.MessageDigest;

/** 
* 功能：支付宝MD5签名处理核心文件，不需要修改
* 版本：3.3
* 修改日期：2012-08-17
* 说明：
* 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
* 该代码仅供学习和研究支付宝接口使用，只是提供一个
* */

public class MD5 {
	/**
	 * 将字符串加密，得到加密字符串
	 * 
	 * @param sSecret
	 * @return String
	 */
	public static String getMd5Value(String sSecret) {
		try {
			MessageDigest bmd5 = MessageDigest.getInstance("MD5");
			bmd5.update(sSecret.getBytes("utf-8"));
			int i;
			StringBuffer buf = new StringBuffer();
			byte[] b = bmd5.digest();
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(MD5.getMd5Value("mer_code=20111117360&mer_trade_code=KT-1402565783151716&notify_url=http://mi.kting.cn/api/pay/qiHuPayCallBack.action&product_name=酷听&rec_amount=10&sign_type=MD5Xy+svEIVDRFiawlv1QwRSQ=="));
	}
}
package com.cros.util;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XML2List {
	/**  
	 * 解析xml字符串成List<Map>  
	 *   
	 * @param String 
	 * @return List  
	 */  
	public static List parseToList(String xmlDoc) {   
	    // 创建一个新的字符串   
	    StringReader xmlString = new StringReader(xmlDoc);   
	    // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入   
	    InputSource source = new InputSource(xmlString);   
	    // 创建一个新的SAXBuilder   
	    SAXBuilder saxb = new SAXBuilder();   
	  
	    List result = null;   
	    try {   
	        result = new ArrayList();   
	        // 通过输入源构造一个Document   
	        Document doc = saxb.build(source);   
	        // 取的根元素   
	        Element root = doc.getRootElement();   
	  
	        // 得到根元素所有子元素的集合   
	        List node = root.getChildren();   
	        Element et = null;   
	        for (int i = 0; i < node.size(); i++) {   
	            et = (Element) node.get(i);// 循环依次得到子元素   
	            List subNode = et.getChildren(); // 得到内层子节点   
	            Map map = new HashMap();   
	            Element subEt = null;   
	            for (int j = 0; j < subNode.size(); j++) {   
	                subEt = (Element) subNode.get(j); // 循环依次得到子元素   
	                map.put(subEt.getName(), subEt.getText()); // 装入到Map中   
	            }   
	  
	            // Map获取到值时才装入   
	            if (map.size() > 0)   
	                result.add(map);   
	        }   
	    } catch (JDOMException e) {   
	        e.printStackTrace();   
	    } catch (IOException e) {   
	        e.printStackTrace();   
	    }   
	    return result;   
	} 
	public static Map<String,String> parseToMap(String xmlDoc) {   
	    // 创建一个新的字符串   
	    StringReader xmlString = new StringReader(xmlDoc);   
	    // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入   
	    InputSource source = new InputSource(xmlString);   
	    // 创建一个新的SAXBuilder   
	    SAXBuilder saxb = new SAXBuilder();   

        Map<String,String> map = new HashMap<String,String>();
	    try {     
	        // 通过输入源构造一个Document   
	        Document doc = saxb.build(source);   
	        // 取的根元素   
	        Element root = doc.getRootElement();   
	  
	        // 得到根元素所有子元素的集合   
	        List node = root.getChildren();   
	        Element et = null;   
	        for (int i = 0; i < node.size(); i++) {   
	            et = (Element) node.get(i);// 循环依次得到子元素   
	            map.put(et.getName(), et.getText());
	        }   
	    } catch (JDOMException e) {   
	        e.printStackTrace();   
	    } catch (IOException e) {   
	        e.printStackTrace();   
	    }   
	    return map;   
	} 
	public static void main(String[] args){
		String xml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[请使用post方法]]></return_msg></xml>";
		XML2List l = new XML2List();
		Map map = new HashMap();
		map = l.parseToMap(xml);
		System.out.println(map.toString());
	}
}

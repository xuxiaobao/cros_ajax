package com.cros.util;

import org.dom4j.*;
import org.dom4j.io.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class XmlUtil {

	/**
	 * map对象转换为XML
	 *
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String mapToXml(Map<String, String> map) throws IOException {
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("xml");
		document.setRootElement(root);
		for (String key : map.keySet()) {
			Element element = root.addElement(key);
			String value = map.get(key);
			element.setText(value == null ? "" : value);
		}
		Writer writer = new StringWriter();
		OutputFormat format = new OutputFormat();
		format.setSuppressDeclaration(true);
		XMLWriter xmlWriter = new XMLWriter(writer, format);
		xmlWriter.write(document);
		return writer.toString();
	}

	/**
	 * Xml转换为map
	 *
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(String xml) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		Document document = DocumentHelper.parseText(xml);
		List<Element> elementList = document.getRootElement().elements();
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		return map;
	}
}

package com.example.lotorry.net.protocal;

import java.io.IOException;
import java.io.StringWriter;

import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

public class Message {
	
	private Header header = new Header();
	private Body body = new Body();
	
	/**
	 * 序列化整个协议
	 * @param serializer
	 */
	public void serializerMessage(XmlSerializer serializer){
		try {
//			serializer.s
			serializer.startTag(null, "message");
			serializer.attribute(null, "version", "1.0");
			header.serializerHeader(serializer, body.getWholeBody());
			
//			body.serializerBody(serializer);
			serializer.startTag(null, "body");
			serializer.text(body.getBodyInsideDESInfo());
			serializer.endTag(null, "body");
			
			serializer.endTag(null, "message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String createXml(Element element){
		if (element == null) {
			throw new IllegalArgumentException("element is null");
		}
		// 请求标示需要设置，请求内容需要设置
		header.getTransactiontype().setTagValue(element.getTransactionType());
		body.getElements().add(element);
		// 序列化
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
			serializer.startDocument("utf-8", true);
			this.serializerMessage(serializer);
			serializer.endDocument();
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 需要处理的问题
	// 1、md5处理的时候需要一个明文的body
	// 2、请求的标示需要设置，内容也需要设置
	// 3、加密body里面的数据
	
	// 5、Elment的通用问题
	
}

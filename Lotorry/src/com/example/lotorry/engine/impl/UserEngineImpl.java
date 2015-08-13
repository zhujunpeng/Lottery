package com.example.lotorry.engine.impl;

import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.example.lotorry.ConstantValue;
import com.example.lotorry.bean.User;
import com.example.lotorry.engine.BaseEngine;
import com.example.lotorry.engine.UserEngine;
import com.example.lotorry.net.protocal.Message;
import com.example.lotorry.net.protocal.element.UserLoginElement;
import com.example.lotorry.utils.DES;

public class UserEngineImpl extends BaseEngine implements UserEngine {
	/**
	 * 用户登陆
	 * 
	 * @param user
	 */
	public Message login(User user) {
		// 第一步：获取到登录用的xml
		// 创建登录用Element
		UserLoginElement element = new UserLoginElement();
		// 设置用户数据
		element.getActpassword().setTagValue(user.getPassword());
		// Message.getXml(element)
		Message message = new Message();
		message.getHeader().getUsername().setTagValue(user.getUsername());
		String xml = message.createXml(element);

		// 如果第三步比对通过result，否则返回空
		Message result = getResult(xml);

		if (result != null) {

			// 第四步：请求结果的数据处理
			// body部分的第二次解析，解析的是明文内容

			XmlPullParser parser = Xml.newPullParser();
			try {

				DES des = new DES();
				String body = "<body>" + des.authcode(result.getBody().getServiceBodyInsideDESInfo(), "ENCODE", ConstantValue.DES_PASSWORD) + "</body>";

				parser.setInput(new StringReader(body));

				int eventType = parser.getEventType();
				String name;

				while (eventType != XmlPullParser.END_DOCUMENT) {
					switch (eventType) {
					case XmlPullParser.START_TAG:
						name = parser.getName();
						if ("errorcode".equals(name)) {
							result.getBody().getOelement().setErrorcode(parser.nextText());
						}
						if ("errormsg".equals(name)) {
							result.getBody().getOelement().setErrormsg(parser.nextText());

						}
						break;
					}
					eventType = parser.next();
				}

				return result;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;

	}

	@Override
	public Message getBalance(User user) {
		return null;
	}

	@Override
	public Message bet(User user) {
		return null;
	}
}

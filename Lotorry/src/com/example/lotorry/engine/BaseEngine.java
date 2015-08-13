package com.example.lotorry.engine;

import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.example.lotorry.ConstantValue;
import com.example.lotorry.net.HttpClientUtil;
import com.example.lotorry.net.protocal.Message;
import com.example.lotorry.utils.DES;

public abstract class BaseEngine {
	public Message getResult(String xml) {
		// 第二步和第三�?

		// 第二�?(代码不变)：发送xml到服务器端，等待回复
		// HttpClientUtil.sendXml
		// 在这行代码前，没有判断网络类型？
		HttpClientUtil util = new HttpClientUtil();
		InputStream is = util.sendXml(ConstantValue.LOTTERY_URI, xml);
		// 判断输入流非�?
		if (is != null) {
			Message result = new Message();

			// 第三�?(代码不变)：数据的校验（MD5数据校验�?
			// timestamp+digest+body
			XmlPullParser parser = Xml.newPullParser();
			try {
				parser.setInput(is, ConstantValue.ENCONDING);

				int eventType = parser.getEventType();
				String name;

				while (eventType != XmlPullParser.END_DOCUMENT) {
					switch (eventType) {
					case XmlPullParser.START_TAG:
						name = parser.getName();
						if ("timestamp".equals(name)) {
							result.getHeader().getTimestamp()
									.setTagValue(parser.nextText());
						}
						if ("digest".equals(name)) {
							result.getHeader().getDigest()
									.setTagValue(parser.nextText());
						}
						if ("body".equals(name)) {
							result.getBody().setServiceBodyInsideDESInfo(
									parser.nextText());
						}
						break;
					}
					eventType = parser.next();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 原始数据还原：时间戳（解析）+密码（常量）+body明文（解�?+解密DES�?
			// body明文（解�?+解密DES�?
			DES des = new DES();
			String body = "<body>"
					+ des.authcode(result.getBody()
							.getServiceBodyInsideDESInfo(), "ENCODE",
							ConstantValue.DES_PASSWORD) + "</body>";

			String orgInfo = result.getHeader().getTimestamp().getTagValue()
					+ ConstantValue.AGENTER_PASSWORD + body;

			// 利用工具生成手机端的MD5
			String md5Hex = DigestUtils.md5Hex(orgInfo);
			// 将手机端与服务器的进行比�?
			if (md5Hex.equals(result.getHeader().getDigest().getTagValue())) {
				// 比对通过
				return result;
			}
		}

		return null;
	}
}

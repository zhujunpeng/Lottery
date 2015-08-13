package com.example.lotorry.net.protocal;

import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

/**
 * 请求数据的封装
 * @author Administrator
 *
 */
public abstract class Element {
	// 不会将所有的请求的叶子都放在element中
	// Element将作为所有的请求作为代表，Element锁清秋的公共部分
	// 1、每个请求都需要序列化自己
	/**
	 * 每个请求都需要序列化自己
	 * @param serializer
	 */
	public abstract void serializerElement(XmlSerializer serializer);
	// 2、每个请求都有自己的标示
	/**
	 * 每个请求都有自己的标示
	 * @return
	 */
	public abstract String getTransactionType();
	// 唯一的标示
	// <lotteryid>118</lotteryid>
//	private Leaf lotteryid = new Leaf("lotteryid");
//	// <issues>1</issues>
//	private Leaf issues = new Leaf("issues", "1");
//	/**
//	 * 序列化请求
//	 * @param serializer
//	 */
//	public void serializerElement(XmlSerializer serializer){
//		try {
//			serializer.startTag(null, "element");
//			lotteryid.serializerLeaf(serializer);
//			issues.serializerLeaf(serializer);
//			serializer.endTag(null, "element");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public Leaf getLotteryid() {
//		return lotteryid;
//	}
//	public String getTransactionType(){
//		return "12002";
//	}
}

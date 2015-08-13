package com.example.lotorry;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public interface ConstantValue {
	// class :public static final
	String ENCONDING="UTF-8";
	/**
	 * 代理商id
	 */
	String AGENTERID="889931";
//	<source>ivr</source>
	/**
	 * 信息来源
	 */
	String SOURCE="ivr";
	//<compress>DES</compress>
	/**
	 * body里面的数据的加密方式
	 */
	String COMPRESS="DES";
	
	/**
	 * 子代理商的密码(.so) JNI
	 */
	String AGENTER_PASSWORD = "9ab62a694d8bf6ced1fab6acd48d02f8";
	
	/**
	 * des加密用的秘钥
	 */
	String DES_PASSWORD = "9b2648fcdfbad80f";
	/**
	 * 服务器地址
	 */
	String LOTTERY_URI = "http://10.0.2.2:8080/ZCWService/Entrance";
	// String LOTTERY_URI = "http://192.168.1.100:8080/ZCWService/Entrance";
	
	
	int VIEW_FIRST=1;
	int VIEW_SECOND=2;
	
	/**
	 * 购彩大厅
	 */
	int VIEW_HALL=10;
	/**
	 * 双色球选好界面
	 */
	int VIEW_SSQ=15;
	/**
	 * 购物车
	 */
	int VIEW_SHOPPING=20;
	/**
	 * 追期和倍投的设置界面
	 */
	int VIEW_PREBET=25;
	/**
	 * 用户登陆
	 */
	int VIEW_LOGIN=30;
	/**
	 * 双色球标示
	 */
	int SSQ=118;
	/**
	 * 服务器返回的状态码
	 */
	String SUCCESS="0";
	

}

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
	 * 淇℃伅鏉ユ簮
	 */
	String SOURCE="ivr";
	//<compress>DES</compress>
	/**
	 * body的加密方式
	 */
	String COMPRESS="DES";
	
	/**
	 * 密码(.so) JNI
	 */
	String AGENTER_PASSWORD = "9ab62a694d8bf6ced1fab6acd48d02f8";
	
	/**
	 * des鍔犲瘑鐢ㄥ瘑閽�
	 */
	String DES_PASSWORD = "9b2648fcdfbad80f";
	/**
	 * 鏈嶅姟鍣ㄥ湴鍧�
	 */
	String LOTTERY_URI = "http://10.0.2.2:8080/ZCWService/Entrance";// 10.0.2.2妯℃嫙鍣ㄥ鏋滈渶瑕佽窡PC鏈洪�氫俊127.0.0.1
	// String LOTTERY_URI = "http://192.168.1.100:8080/ZCWService/Entrance";// 10.0.2.2妯℃嫙鍣ㄥ鏋滈渶瑕佽窡PC鏈洪�氫俊127.0.0.1
	
	
	int VIEW_FIRST=1;
	int VIEW_SECOND=2;
	
	/**
	 * 璐僵澶у巺
	 */
	int VIEW_HALL=10;
	/**
	 * 鍙岃壊鐞冮�夊彿鐣岄潰
	 */
	int VIEW_SSQ=15;
	/**
	 * 璐墿杞�
	 */
	int VIEW_SHOPPING=20;
	/**
	 * 杩芥湡鍜屽�嶆姇鐨勮缃晫闈�
	 */
	int VIEW_PREBET=25;
	/**
	 * 鐢ㄦ埛鐧诲綍
	 */
	int VIEW_LOGIN=30;
	/**
	 * 鍙岃壊鐞冩爣绀�
	 */
	int SSQ=118;
	/**
	 * 鏈嶅姟鍣ㄨ繑鍥炴垚鍔熺姸鎬佺爜
	 */
	String SUCCESS="0";
	

}

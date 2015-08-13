package com.example.lotorry.test;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.lotorry.net.protocal.Message;
import com.example.lotorry.net.protocal.element.CurrIssueElement;

public class XmlTest extends AndroidTestCase {
	
	private static final String TAG = "XmlTest";

	public void createXml(){
		Message message = new Message();
		CurrIssueElement element = new CurrIssueElement();
		element.getLotteryid().setTagValue("118");
		String xml = message.createXml(element);
		Log.i(TAG, xml);
	}

}

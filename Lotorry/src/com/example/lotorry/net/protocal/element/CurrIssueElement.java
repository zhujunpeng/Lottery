package com.example.lotorry.net.protocal.element;

import org.xmlpull.v1.XmlSerializer;

import com.example.lotorry.net.protocal.Element;
import com.example.lotorry.net.protocal.Leaf;

public class CurrIssueElement extends Element {
	private Leaf lotteryid = new Leaf("lotteryid");
	private Leaf issues = new Leaf("issues", "1");
	@Override 
	public void serializerElement(XmlSerializer serializer) {
		try {
			serializer.startTag(null, "element");
			lotteryid.serializerLeaf(serializer);
			issues.serializerLeaf(serializer);
			serializer.endTag(null, "element");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getTransactionType() {
		return "12002";
	}

	public Leaf getLotteryid() {
		return lotteryid;
	}

}

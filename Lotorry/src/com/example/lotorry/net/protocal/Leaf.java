package com.example.lotorry.net.protocal;

import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

public class Leaf {
	
	private String tagName;
	private String tagValue;
	
	public Leaf(String tagName) {
		super();
		this.tagName = tagName;
	}

	public Leaf(String tagName, String tagValue) {
		super();
		this.tagName = tagName;
		this.tagValue = tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public void serializerLeaf(XmlSerializer serializer){
		try {
			serializer.startTag(null, tagName);		// <name>
			if (tagValue == null) {
				tagValue = "";
			}
			serializer.text(tagValue);
			serializer.endTag(null, tagName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

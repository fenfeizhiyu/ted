package com.ted.resource;

public class CleanByRegex {
	
	private String str;

	
	
	
	
	public String clean(String regex,String replaceStr){
		return str.replaceAll(regex,replaceStr);
	}
	
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
	
}

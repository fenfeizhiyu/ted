package com.ted.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * ȥ���ַ�������Ķ�����ַ��� �����ַ�char c
	 */
	public static String delStringByChar(String str,char c){
		return str.substring(0, str.lastIndexOf(c));
	}
	
	/**
	 * ȥ��ָ���ַ���
	 * @param str
	 * @param delString
	 * @return
	 */
	public static String delStringByString(String str,String delString){
		return str.replace(delString,"");
	}
	
	public static void main(String[] args){
		System.out.println(getFieldName("CLASS_TYPE_PARAMETER_BOUND=0x11"));
	}
	
	/**
	 * ��ӡList
	 */
	public static String printList(List<String> list,String title){
		StringBuilder sb=new StringBuilder(title+": \r\n");
		if(list==null){
			return title+": null\r\n";
		}
		for(String s:list){
			sb.append(s+"\r\n");
		}
		return sb.toString();
	}	
	
	public static String getFieldName(String str){
		if(str.contains("=")){
			str=str.replaceAll("\\s*=[\\s\\w]*","");
			return str;
		}
		return str;
	}
	
	public static void getMethodName(String str){
		 Pattern pattern = Pattern.compile("\\.[\\s]*[\\w]+[\\s]*\\(");
		 Matcher matcher = pattern.matcher(str);
		 if(matcher.find()){
			System.out.println("���÷�����:"+matcher.groupCount()); 
		 }
	}
}

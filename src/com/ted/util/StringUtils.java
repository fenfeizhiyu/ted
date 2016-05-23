package com.ted.util;

import java.util.List;

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
		System.out.println(delStringByString("import javax.servlet.http.HttpServletRequest","import "));
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
}

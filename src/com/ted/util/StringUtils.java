package com.ted.util;

import java.util.List;

public class StringUtils {

	/**
	 * 去除字符串里面的多余的字符串 包括字符char c
	 */
	public static String delStringByChar(String str,char c){
		return str.substring(0, str.lastIndexOf(c));
	}
	
	/**
	 * 去除指定字符串
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
	 * 打印List
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

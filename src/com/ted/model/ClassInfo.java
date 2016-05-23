package com.ted.model;

import java.util.List;
import java.util.Map;

public class ClassInfo {

	/**
	 * �ļ�·����
	 */
	private String pathName;
	/**
	 * �ӿ�����
	 */
	private List<String> interfaceName;
	/**
	 * ��������
	 */
	private String superClassName;
	/**
	 * ������
	 */
	private String className;
	/**
	 * ����������
	 */
	private List<String> importName;
	/**
	 * �ֶ�
	 */
	private List<String> fields;
	/**
	 *  ��������_������
	 */
	private List<String> method;
	
	
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<String> getImportName() {
		return importName;
	}
	public void setImportName(List<String> importName) {
		this.importName = importName;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public List<String> getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(List<String> interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getSuperClassName() {
		return superClassName;
	}
	public void setSuperClassName(String superClassName) {
		this.superClassName = superClassName;
	}
	public List<String> getMethod() {
		return method;
	}
	public void setMethod(List<String> method) {
		this.method = method;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("pathName"+pathName+"\r\n");
		sb.append("className :"+className+"\r\n");
		sb.append(printList(importName,"imports"));
		sb.append("superclassName :"+superClassName+"\r\n");
		sb.append(printList(interfaceName,"interfaces"));
		sb.append(printList(fields,"fields"));
		sb.append(printList(method,"method"));
		return sb.toString();
	}
	
	
	private String printList(List<String> list,String title){
		StringBuilder sb=new StringBuilder(title+": \r\n");
		if(list==null){
			return title+": null\r\n";
		}
		sb.append("*******************\r\n");
		for(String s:list){
			sb.append(s+"\r\n");
		}
		sb.append("*******************\r\n");
		return sb.toString();
		
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}	
}

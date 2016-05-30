package com.ted.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ted.constant.ResourceConstant;

/**
 * 类的基本信息
 * @author yu.yang
 *
 */
public class ClassInfo implements Serializable{

	private static final long serialVersionUID = -8059949133788326259L;
	
	private int id;
	
	
	
	public ClassInfo(){
		id=ResourceConstant.classInfoStartId;
		ResourceConstant.classInfoStartId++;
	}
	/**
	 * 文件路径名
	 */
	private String pathName;
	/**
	 * 接口名称
	 */
	private List<String> interfaceName;
	/**
	 * 父类名称
	 */
	private String superClassName;
	/**
	 * 类名称
	 */
	private String className;
	/**
	 * 导入类名称
	 */
	private List<String> importName;
	/**
	 * 字段
	 */
	private List<String> fields;
	/**
	 *  返回类型_方法名
	 */
	private List<String> method;
	
	/**
	 *
	 */
	private List<String> methodCalls=new ArrayList<String>();
	
	private int quoteNum;
	
	
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
		sb.append("class Info id :"+this.id+"\r\n");
		sb.append("packageName : "+pathName+"\r\n");
		sb.append("className :"+className+"\r\n");
		sb.append(printList(importName,"imports"));
		sb.append("superclassName : "+superClassName+"\r\n");
		sb.append(printList(interfaceName,"interfaces"));
		sb.append(printList(fields,"fields"));
		sb.append(printList(method,"method"));
		sb.append("methodsCallNum is :"+this.methodCalls.size()+"\r\n");
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getMethodCalls() {
		return methodCalls;
	}
	public void setMethodCalls(List<String> methodCalls) {
		this.methodCalls = methodCalls;
	}
	
	
	public void addMethodCall(String methodCall){
		this.methodCalls.add(methodCall);
	}
	public int getQuoteNum() {
		return quoteNum;
	}
	public void setQuoteNum(int quoteNum) {
		this.quoteNum = quoteNum;
	}
	
	
	
}

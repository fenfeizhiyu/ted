package com.ted.model;

import java.util.List;
import java.util.Map;

public class ClassInfo {

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
	private Map<String,String> fields;
	/**
	 * 方法
	 */
	private String methodName;
	
	
	
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
	public Map<String, String> getFields() {
		return fields;
	}
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	
}

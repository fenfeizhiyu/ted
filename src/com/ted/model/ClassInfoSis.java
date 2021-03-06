package com.ted.model;

import java.io.Serializable;


/*
 * 类的统计信息
 */
public class ClassInfoSis implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 信息Id
	 */
	private int classId;
	
	/**
	 * 类型名称
	 */
	private int className;
	
	/**
	 * 引用次数
	 */
	private int quoteNum;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getClassName() {
		return className;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public int getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(int quoteNum) {
		this.quoteNum = quoteNum;
	}
	
	
	
	
	
}

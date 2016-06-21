package com.ted.search;

import java.util.List;

import com.ted.model.ClassInfo;
import com.ted.model.ClassInfoSis;

public class DataHolder {

	/**
	 * 类信息集合
	 */
	private List<ClassInfo> classInfos;
	
	/**
	 * 类信息统计
	 */
	private List<ClassInfoSis> classInfoSises;
	
	
	
	

	public List<ClassInfo> getClassInfos() {
		return classInfos;
	}

	public void setClassInfos(List<ClassInfo> classInfos) {
		this.classInfos = classInfos;
	}

	public List<ClassInfoSis> getClassInfoSises() {
		return classInfoSises;
	}

	public void setClassInfoSises(List<ClassInfoSis> classInfoSises) {
		this.classInfoSises = classInfoSises;
	}
	
	
	
	
}

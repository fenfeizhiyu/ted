package com.ted.search;

import java.util.List;

import com.ted.model.ClassInfo;
import com.ted.model.ClassInfoSis;

public class DataHolder {

	/**
	 * ����Ϣ����
	 */
	private List<ClassInfo> classInfos;
	
	/**
	 * ����Ϣͳ��
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

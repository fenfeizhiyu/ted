package com.ted.parser;

import java.util.Arrays;
import java.util.List;

import com.ted.constant.ResourceConstant;
import com.ted.resource.CleanClassSourceByChar;
import com.ted.resource.DirtyInfo;
import com.ted.resource.FileOperation;
import com.ted.resource.FileSource;
import com.ted.resource.JavaFileFilter;

public class ClassSource {
	
	private static FileSource fs=new FileSource("D:\\log\\code");
	
	
	public ClassSource(String path){
		fs=new FileSource(path);
	}
	
	
	
	
	
	/**
	 * 获得一个清理过后的标示符
	 * @param filePath
	 * @param dirtyInfos
	 * @return
	 */
	public String getCleanSourceString(String filePath,DirtyInfo[] dirtyInfos){
		//清理java文件
		String str=FileOperation.readFileAsString(filePath, "UTF_8");
		CleanClassSourceByChar ccs=CleanClassSourceByChar.getCleanClassSourceByChar(str);
		//注册清理标示符
		for(DirtyInfo dirty:dirtyInfos){
			ccs.addDirtyInfo(dirty);
		}
		//开始清理
		char[] by=ccs.doClean();
		return new String(by);
	}
	
	
	

	public static void main(String[] args){
		fs.registerFilter(new JavaFileFilter());
		fs.searchAllFiles();
		List<String> fps=fs.getFilePaths();
		String str=FileOperation.readFileAsString(fps.get(1),"UTF-8");
		CleanClassSourceByChar ccs=CleanClassSourceByChar.getCleanClassSourceByChar(str);
		//System.out.println(ccs.getSourceStrChars().length);
	    ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.fanxiegang,new int[]{ResourceConstant.fanxiegang,ResourceConstant.fanxiegang}));
	    ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.a,new int[]{ResourceConstant.a}));
		char[] by=ccs.doClean();
		//System.out.println(ccs.getSourceStrChars().length);
		System.out.println(new String(by));
		
		/*
		for(String s:fps){
			System.out.println(s);
		}
		*/
	}
}

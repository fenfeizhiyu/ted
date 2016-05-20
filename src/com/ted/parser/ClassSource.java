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
	
	
	public void start(){
		fs.searchAllFiles();
		
	}
	
	public static void main(String[] args){
		fs.registerFilter(new JavaFileFilter());
		fs.searchAllFiles();
		List<String> fps=fs.getFilePaths();
		String str=FileOperation.readFileAsString(fps.get(1),"UTF-8");
		CleanClassSourceByChar ccs=new CleanClassSourceByChar(str);
		System.out.println(ccs.getSourceStrChars().length);
	    ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.fanxiegang,new int[]{ResourceConstant.fanxiegang,ResourceConstant.fanxiegang}));
		char[] by=ccs.doClean();
		System.out.println(ccs.getSourceStrChars().length);
		System.out.println(new String(by));
		
		/*
		for(String s:fps){
			System.out.println(s);
		}
		*/
	}
}

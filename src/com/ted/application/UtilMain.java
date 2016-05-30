package com.ted.application;

import java.io.File;
import java.util.List;

public class UtilMain {

	public static void main(String[] args) {
		File file=new File("C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE");
		File[] files=file.listFiles();
		String[] strs=new String[]{"",""};
		StringBuilder sb=new StringBuilder("String[] strs=new String[]{\"");
		StringBuilder sbpro=new StringBuilder("String[] projectNames=new String[]{\"");
	
		for(File f:files){
			if(f.isDirectory()){
				sb.append(f.getAbsolutePath()+"\",\"");
				sbpro.append(f.getName()+"\",\"");
			}
		}
		sb.append("\"};");
		sbpro.append("\"};");
		System.out.println(sb.toString());
		System.out.println(sbpro.toString());

	}

}

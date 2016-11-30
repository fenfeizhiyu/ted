package com.ted.application;

import java.util.List;

import com.ted.cache.ClassInfoCache;
import com.ted.model.ClassInfo;
import com.ted.resource.FileOperation;
import com.ted.util.LuanchUtil;

public class AnalysisApplication {

	public static void main(String[] args) {
		ClassInfoCache classInfoCache =LuanchUtil.LoadCache("D:\\log\\classCache2", "spring-beans.txt");
		List<ClassInfo> cis=classInfoCache.getCis();
		StringBuilder sb=new StringBuilder();
		/*
		for(ClassInfo cInfo:cis){
			//System.out.println(cInfo.getClassName());
			int count=seachImportsNum(classInfoCache,cInfo.getClassName());
			sb.append(cInfo.getClassName()+"_"+count+"\t\n");
		}*/
		//FileOperation.writeStringToFile(sb.toString(),FileOperation.createFile("D:\\log\\", "indexPrint.txt"));
		seachImports(classInfoCache,"FactoryBean");
	}

	
	public static Integer seachImportsNum(ClassInfoCache classInfoCache,String className){
		List<ClassInfo> cis=classInfoCache.getCis();
		int count=0;
		for(ClassInfo ci:cis){
			List<String> names=ci.getImportName();
			if(names!=null&&names.size()>0){
				for(String str:ci.getImportName()){
					if(str!=null){
						if(str.equals(className)||str.endsWith("."+className))
							count++;
							break;
					}
				}
			}
		}
		return count;
	}
	
	/**
	 * 搜索引用该类名的类
	 * @param classInfoCache
	 * @param className
	 */
	public static void seachImports(ClassInfoCache classInfoCache,String className){
		List<ClassInfo> cis=classInfoCache.getCis();
		for(ClassInfo ci:cis){
			List<String> names=ci.getImportName();
			if(names!=null&&names.size()>0){
				for(String str:ci.getImportName()){
					if(str!=null){
						if(str.equals(className)||str.endsWith("."+className))
							System.out.println(ci.getClassName());
							break;
					}
				}
			}
		}
	}
}

package com.ted.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.ted.cache.CacheRuner;
import com.ted.cache.ClassInfoCache;
import com.ted.constant.ResourceConstant;
import com.ted.model.ClassInfo;
import com.ted.parser.ClassInfoVisitor;
import com.ted.parser.ParserClass;
import com.ted.parser.ParserFactory;
import com.ted.resource.CleanClassSourceByChar;
import com.ted.resource.DirtyInfo;
import com.ted.resource.FileOperation;
import com.ted.resource.FileSource;
import com.ted.resource.JavaFileFilter;

public class SearchRunMain {
	
	
	private static final String path="D:/log/code/";
	private static  String path2="C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE";
	private static final String repath="";
	private static  int totalNum;
	private static  int currNums;
	private static String pro="spring-websocket";
	
	public static void main(String[] args) throws Exception {
		path2=path2+"\\"+pro;
		long start=System.currentTimeMillis();
		List<ClassInfo> classInfos=new ArrayList<ClassInfo>();
		/**
		 * 搜索java文件
		 */
		FileSource fileSource=new FileSource(path2);
		fileSource.registerFilter(new JavaFileFilter());
		fileSource.searchAllFiles();
		List<String> filePaths=fileSource.getFilePaths();
		totalNum=filePaths.size();
		System.out.println("总共"+totalNum);
		for(int j=0;j<filePaths.size();j++){
			/**
			 * 解析java文件中的类
			 */
			ParserClass pc=getParserClass(filePaths.get(j),"UTF-8");
			System.out.println(filePaths.get(j));
			List typelist=pc.parserClassTypes();
			for(int i=0;i<typelist.size();i++){
				TypeDeclaration typeDe=(TypeDeclaration)typelist.get(i);
				ClassInfo classInfo=pc.getClassInfoByType(typeDe);
				classInfos.add(classInfo);
			}
			System.out.println("总共"+totalNum+";已完成"+j);
		}
		System.out.println("总耗时"+(System.currentTimeMillis()-start)+"毫秒");
		CacheRuner cr=new CacheRuner("D:\\log\\classCache");
		ClassInfoCache cic=new ClassInfoCache();
		cic.setCis(classInfos);
		cic.setSaveDate("2016-5-27");
		cic.setPojectName(pro);
		cic.setSaveName(pro+".txt");
		cr.saveToDisk(cic);
		/*
		for(ClassInfo c:classInfos){
			System.out.println(c);
			System.out.println("-------------------------");
		}*/
		
	}
	
	
	
	public static ParserClass getParserClass(String filePath,String encoding){
		/**
		 * 清理java文件
		 */
		String str=FileOperation.readFileAsString(filePath,encoding);
		//CleanClassSourceByChar ccs=CleanClassSourceByChar.getCleanClassSourceByChar(str);
		//ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.fanxiegang,new int[]{ResourceConstant.fanxiegang,ResourceConstant.fanxiegang}));
	   // ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.a,new int[]{ResourceConstant.a}));
	   // char[] by=ccs.doClean();
	    
	    /**
		 * 解析java文件
		 */
	    ASTParser ap= ParserFactory.getAstParser(str);
	    CompilationUnit result =(CompilationUnit)ap.createAST(null);
	    ClassInfo ci=new ClassInfo();
	    ClassInfoVisitor mv=new ClassInfoVisitor(ci);
	    result.accept(mv);
		ParserClass pc=ParserClass.getParserClass(result,ci);
		return pc;
	}
	
	
	
	
}

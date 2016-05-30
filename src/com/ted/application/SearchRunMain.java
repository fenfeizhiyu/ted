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
	private static  String path2="D:\\log\\c3p0-0.9.1.2-sources\\com";
	private static final String repath="";
	private static  int totalNum;
	private static  int currNums;
	private static String pro="c3p0";
	//static String[] strs=new String[]{"C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-aspects","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-beans","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-beans-groovy","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-context","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-context-support","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-core","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-expression","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-framework-bom","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-instrument","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-instrument-tomcat","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-jdbc","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-jms","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-messaging","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm-hibernate4","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm-hibernate5","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-oxm","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-test","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-tx","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-web","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc-portlet","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc-tiles2","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-websocket"};
	//static String[] projectNames=new String[]{"spring-aspects","spring-beans","spring-beans-groovy","spring-context","spring-context-support","spring-core","spring-expression","spring-framework-bom","spring-instrument","spring-instrument-tomcat","spring-jdbc","spring-jms","spring-messaging","spring-orm","spring-orm-hibernate4","spring-orm-hibernate5","spring-oxm","spring-test","spring-tx","spring-web","spring-webmvc","spring-webmvc-portlet","spring-webmvc-tiles2","spring-websocket","src",""};

	
	
	
	public static void main(String[] args) throws Exception{
		long start=System.currentTimeMillis();
		

		//domain(strs[i],projectNames[i]);
		domain(path2,pro);

		System.out.println("总耗时"+(System.currentTimeMillis()-start)+"毫秒");
	}
	
	
	
	public static void domain(String p,String projectName) throws Exception {
		//p=p+"\\src\\main";
		pro=projectName;
		long start=System.currentTimeMillis();
		List<ClassInfo> classInfos=new ArrayList<ClassInfo>();
		System.out.println("正在处理 :"+pro+"----"+p);
		/**
		 * 搜索java文件
		 */
		FileSource fileSource=new FileSource(p);
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
			//System.out.println(filePaths.get(j));
			List typelist=pc.parserClassTypes();
			for(int i=0;i<typelist.size();i++){
				TypeDeclaration typeDe=(TypeDeclaration)typelist.get(i);
				ClassInfo classInfo=pc.getClassInfoByType(typeDe);
				classInfos.add(classInfo);
			}
			//System.out.println("总共"+totalNum+";已完成"+j);
		}
		System.out.println("耗时"+(System.currentTimeMillis()-start)+"毫秒");
		CacheRuner cr=new CacheRuner("D:\\log\\classCache2");
		ClassInfoCache cic=new ClassInfoCache();
		cic.setCis(classInfos);
		cic.setSaveDate("2016-5-27");
		cic.setPojectName(pro);
		cic.setSaveName(pro+".txt");
		cr.saveToDisk(cic);
		fileSource.clearFilesList();
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

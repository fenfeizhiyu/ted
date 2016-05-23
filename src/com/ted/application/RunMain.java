package com.ted.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.ted.constant.ResourceConstant;
import com.ted.model.ClassInfo;
import com.ted.parser.ParserClass;
import com.ted.parser.ParserFactory;
import com.ted.resource.CleanClassSourceByChar;
import com.ted.resource.DirtyInfo;
import com.ted.resource.FileOperation;
import com.ted.resource.FileSource;
import com.ted.resource.JavaFileFilter;

public class RunMain {
	
	
	private static final String path="D:/log/code/";
	
	
	public static void main(String[] args) throws Exception {
		
		List<ClassInfo> classInfos=new ArrayList<ClassInfo>();
		/**
		 * 搜索java文件
		 */
		FileSource fileSource=new FileSource(path);
		fileSource.registerFilter(new JavaFileFilter());
		fileSource.searchAllFiles();
		List<String> filePaths=fileSource.getFilePaths();
		for(String path:filePaths){
			/**
			 * 解析java文件中的类
			 */
			ParserClass pc=getParserClass(path,"UTF-8");
			List typelist=pc.parserClassTypes();
			for(int i=0;i<typelist.size();i++){
				TypeDeclaration typeDe=(TypeDeclaration)typelist.get(i);
				ClassInfo classInfo=pc.getClassInfoByType(typeDe);
				classInfos.add(classInfo);
			}
		}
		for(ClassInfo c:classInfos){
			System.out.println(c);
			System.out.println("-------------------------");
		}
		
	}
	
	
	
	public static ParserClass getParserClass(String filePath,String encoding){
		/**
		 * 清理java文件
		 */
		String str=FileOperation.readFileAsString(filePath,encoding);
		CleanClassSourceByChar ccs=CleanClassSourceByChar.getCleanClassSourceByChar(str);
		ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.fanxiegang,new int[]{ResourceConstant.fanxiegang,ResourceConstant.fanxiegang}));
	    ccs.addDirtyInfo(new DirtyInfo(ResourceConstant.a,new int[]{ResourceConstant.a}));
	    char[] by=ccs.doClean();
	    
	    /**
		 * 解析java文件
		 */
	    ASTParser ap= ParserFactory.getAstParser(by);
	    CompilationUnit result =(CompilationUnit)ap.createAST(null);
		ParserClass pc=ParserClass.getParserClass(result);
		return pc;
	}
	
	
	
	
}

package com.ted.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.ted.model.ClassInfo;
import com.ted.util.StringUtils;

public class ParserClass {

	private CompilationUnit compilationUnit;
	
	
	private ParserClass(CompilationUnit c){
		compilationUnit=c;
	}
	
	public static ParserClass getParserClass(CompilationUnit compilationUnit){
		return new ParserClass(compilationUnit);
	}
	
	
	/**
	 * 解析一个java类
	 * @return
	 */
	public ClassInfo getClassInfoByType(TypeDeclaration td){
		ClassInfo ci=new ClassInfo();
		ci.setFields(this.parserFieldNamesAndType(td));
		ci.setClassName(td.getName().getFullyQualifiedName());
	    ci.setImportName(this.parserImports());
	    ci.setInterfaceName(this.parserInterfaceType(td));
	    ci.setMethod(this.parserMethods(td));
	    ci.setSuperClassName(this.parserSuperClassName(td));
		return ci;
	}
	
	
	/**
	 * 获取一个java文件中定义的类  org.eclipse.jdt.core.dom.TypeDeclaration;
	 * @return
	 */
	public List parserClassTypes(){
		
		List types=compilationUnit.types();
		return types;
	}
	
	/**
	 * 获取类文件的导入类型
	 * @return
	 */
	public List<String> parserImports(){
		List list=compilationUnit.imports();
		if(list==null||list.size()==0){
			return null;
		}
		List<String> returnList=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			String s=StringUtils.delStringByChar(list.get(i).toString(),';');
			returnList.add(StringUtils.delStringByString(s, "import "));
		}
		return returnList;
	}
	/**
	 * 获取一个类型中的变量定义
	 * @return
	*/
	public List<String> parserFieldNamesAndType(TypeDeclaration td){
		FieldDeclaration[] fields=td.getFields();
		List<String> returnList=new ArrayList<String>();
		for(FieldDeclaration fd:fields){
			returnList.add(fd.toString());
		}
		return returnList;
	} 
	
	/**
	 * 获取方法名和返回类型  返回类型_方法名
	 * @param td
	 * @return
	 */
	public List<String> parserMethods(TypeDeclaration td){
		MethodDeclaration[] mds=td.getMethods();
		List<String> returnList=new ArrayList<String>();
		for(MethodDeclaration md:mds){
			returnList.add(md.getReturnType2().toString()+"_"+md.getName().toString());
		}
		return returnList;
	}
	
	/**
	 * 获取实现的接口
	 * @param td
	 * @return
	 */
	public List<String> parserInterfaceType(TypeDeclaration td){
		List list=td.superInterfaceTypes();
		if(list.size()==0)
			return null;
		List<String> returnList=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			returnList.add(list.get(i).toString());
		}
		return returnList;
	}
	
	/**
	 *获取类型的超类
	 */
	public String parserSuperClassName(TypeDeclaration td){
		if(td.getSuperclassType()!=null)
		  return td.getSuperclassType().toString();
		else 
			return null;
	}
	
	
	
}

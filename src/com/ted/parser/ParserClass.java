package com.ted.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.ted.model.ClassInfo;

public class ParserClass {

	private CompilationUnit CompilationUnit;
	/**
	 * 获取类名
	 * @return
	 */
	public List<ClassInfo> parserClassInfo(){
		
		List types=CompilationUnit.types();
		
		return null;
	}
	
	private ClassInfo doParserClassType(TypeDeclaration type){
		ClassInfo classInfo=new ClassInfo();
		classInfo.setClassName(type.getName().getFullyQualifiedName());
		FieldDeclaration[] fields=type.getFields();
		return null;
	}
	
	private ClassInfo doParserClassFields(FieldDeclaration[] fields,ClassInfo calssInfo){
		Map<String,String> fieldMap=new HashMap<String,String>();
		for(FieldDeclaration field :fields){
			//fieldMap.put(field.,"")
		}
		return null;
	}
	
}

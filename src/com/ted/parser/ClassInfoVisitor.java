package com.ted.parser;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.TypeParameter;

import com.ted.model.ClassInfo;



public class ClassInfoVisitor extends ASTVisitor{

	private ClassInfo ci;

	public  ClassInfoVisitor(ClassInfo ci){
		this.ci=ci;
	}
	




	@Override
	public boolean visit(MethodInvocation node) {
		//System.out.println("MethodInvocation: "+node.toString());
		ci.addMethodCall(node.toString());
		return super.visit(node);
	}

	






	
	
	
	
 
} 

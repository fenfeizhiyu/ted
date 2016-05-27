package com.ted.parser;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;

public class ParserFactory {

	
	/**
	 *    �� K_COMPILATION_UNIT�����뵥Ԫ����һ��Java�ļ�
       �� K_CLASS_BODY_DECLARATIONS���������
       �� K_EXPRESSION���������ʽ
       �� K_STATEMENTS������
	 * 
	 * 
	 * @param source
	 * @return
	 */
	public static ASTParser getAstParser(String source){
		return getAstParser(source.toCharArray());
		
	}
	
	public  static ASTParser getAstParser(char[] source){
		ASTParser parser=ASTParser.newParser(AST.JLS3);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(source);
		parser.setResolveBindings(true);
		return parser;
		
	}
	
	
	
}

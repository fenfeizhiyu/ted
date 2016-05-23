package com.ted.parser;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

public class ParserFactory {

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

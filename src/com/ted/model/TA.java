package com.ted.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;






import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import com.ted.parser.ParserFactory;
import com.ted.resource.FileOperation;
import com.ted.resource.FileSource;




public class TA  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s="D:/log/code/MouldHoudongNotifyController.java";
		File file=new File(s);
		FileInputStream fis=new FileInputStream(file);
		StringBuilder sb=new StringBuilder();
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		char[] chs=new char[1024];
		int len=isr.read(chs);
		while(len!=-1){
			sb.append(chs);
			len=isr.read(chs);
		}
		ParserFactory pf=new ParserFactory();
		ASTParser ap=pf.getAstParser(sb.toString());
		CompilationUnit result=(CompilationUnit) ap.createAST(null);
		List types=result.types();
		List imList=result.imports();
		for(int i=0;i<imList.size();i++){
			System.out.print(imList.get(i).toString());
		}
		TypeDeclaration td=(TypeDeclaration)types.get(0);
		MethodDeclaration[] mds=td.getMethods();
		FieldDeclaration[] fields=td.getFields();
		//System.out.println(td.getSuperclassType().toString());
		List list=td.superInterfaceTypes();
		for(int i=0;i<list.size();i++){
			 System.out.println(list.get(i).toString());
		}
		for(MethodDeclaration md:mds){
			System.out.println(md.getReturnType2().toString()+" "+md.getName().toString());
		}
		Map m=td.properties();
		Iterator iter=m.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry=(Map.Entry)iter.next();
			System.out.println(entry.getKey()+"::"+entry.getValue().toString());
		}
		System.out.println();
		
		/*for(MethodDeclaration md:mds){
			if(md.getJavadoc()!=null)
			System.out.println(md.getJavadoc().toString());
			System.out.println(md.getName());
		}*/
		for(FieldDeclaration fd:fields){
		
			System.out.println(fd.toString());
			//System.out.println(fd.getType());
		}
		System.out.println(td.getName().getFullyQualifiedName()+":medthod num is :"+mds.length);
		
	}
	
	public static void main1(String[] args) throws Exception {
		
		FileSource fs=new FileSource("D:/log/code/");
		//fs.searchAllFiles();
		//PrintUtils.printList(fs.getFilePaths());
		FileOperation.readFileAsInputStream("D:/log/code/MouldHoudongCreateController.java");
		//String s=FileOperation.readFileAsString("D:/log/code/MouldHoudongNotifyController.java","UTF-8");
		//char[] c=s.toCharArray();
		//System.out.println(s);
	}
	

}

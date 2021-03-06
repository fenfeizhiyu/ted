package com.ted.resource;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class FileOperation {

	private final static int bufferReadSize=64;
	
	
	/**
	 * 读取指定的文件内容
	 * @param filePath
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readFileAsString(String filePath,String encoding){
		char[] chs=new char[bufferReadSize];
		FileInputStream fin=null;
		InputStreamReader isr=null;
		try {
			fin=new FileInputStream(filePath);
			isr=new InputStreamReader(fin,encoding);
			StringBuilder sb=new StringBuilder();
			int len=isr.read(chs);
			while(len!=-1){
				sb.append(chs);
				chs=new char[bufferReadSize];
				len=isr.read(chs);
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try
			{
				fin.close();
				isr.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static String readFileAsInputStream(String filePath)throws IOException{
		FileInputStream fin=null;
		byte[] bytes=new byte[1024];
		//StringBuilder sb=new StringBuilder();
		try{
			fin=new FileInputStream(filePath);
			int len=fin.read(bytes);
			while(len!=-1){
				System.out.println(Arrays.toString(bytes));
				bytes=new byte[1024];
				len=fin.read(bytes);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fin.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static  void writeStringToFile(String str,File file){
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(file));
			bw.write(str);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			try{
				bw.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public  static File createFile(String path,String name){
		File file=new File(path+name);
		try{
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}else{
				file.createNewFile();
			}
			return file;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}

package com.ted.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class FileOperation {

	private final static int bufferReadSize=1024;
	/**
	 * 读取指定的文件内容
	 * @param filePath
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readFileAsString(String filePath,String encoding) throws IOException{
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
				for(byte b:bytes){
					System.out.print(b);
				}
				System.out.println();
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
	
	
}

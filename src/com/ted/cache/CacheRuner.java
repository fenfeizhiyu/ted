package com.ted.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CacheRuner {
 
	private static String savaPath=""; 
	
	
	
	public CacheRuner(String savePath){
		this.savaPath=savePath;
	}
	/**
	 * 将对象序列化保存
	 * @param cache
	 * @return
	 */
	public boolean saveToDisk(CacheInterface cache){
		String fileName=cache.getSaveFileName();
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		fileName=getRealFilePath(fileName);
		try {
			File file=createFile(fileName);
			fos=new FileOutputStream(file);
	
			out=new ObjectOutputStream(fos);
			out.writeObject(cache);
			out.flush();
			close(out);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			close(fos);
			close(out);
			return false;
		}
	}
	
	/**
	 * 加载序列化对象
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings("resource")
	public CacheInterface loadCacheFromDisk(String fileName){
		fileName=getRealFilePath(fileName);
		ObjectInputStream in=null;
		try{
			File file=new File(fileName);
		    in = new ObjectInputStream(new FileInputStream(file));
			return (CacheInterface)in.readObject();
		}catch(Exception e){
			e.printStackTrace();
			close(in);
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private String getRealFilePath(String fileName){
		if(fileName.startsWith("/")||fileName.startsWith("\\")){
			 return savaPath+fileName;
		}else
			return savaPath+"/"+fileName;
	}
	
	
	
	public File createFile(String fileName) throws IOException{
		File file=new File(fileName);
		if(!file.exists())
			file.createNewFile();
		else{
			file.delete();
			file.createNewFile();
		}
		return file;
	}
	
	public void close(FileOutputStream fos){
			if(fos!=null){
			try{
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void close(ObjectOutputStream fos){
		if(fos!=null){
			try{
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
	
	public void close(ObjectInputStream fis){
		if(fis!=null){
			try{
				fis.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}

package com.ted.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileSource {

	private String basePath="";
	private File srcFileDir=null;
	/**
	 * 缓存文件路径
	 */
	private List<String> filePaths=new ArrayList<String>();
	/**
	 * 缓存文件名称
	 */
	private List<String> fileNames=new ArrayList<String>();
	
	public String getBasePath() {
	    return basePath;
	}

	public void setBasePath(String basePath) {
	    this.basePath = basePath;
	}

	public File getSrcFileDir() {
	    return srcFileDir;
	}

	public void setSrcFileDir(File srcFileDir) {
	    this.srcFileDir = srcFileDir;
	}

	public List<String> getFilePaths() {
	    return filePaths;
	}

	public void setFilePaths(List<String> filePaths) {
	    this.filePaths = filePaths;
	}

	public void setFileNames(List<String> fileNames) {
	    this.fileNames = fileNames;
	}

	/**
	 * 初始化一个跟目录
	 * @param path
	 */
	public FileSource(String path)
	{
		this.basePath=path;
		init();
	}
	
	private void init()
	{
		 srcFileDir=new File(basePath);
		if(!srcFileDir.exists())
		{
			srcFileDir.mkdirs();
		}
	}
	
	/**
	 *
	 * @param file
	 */
	private void searchFiles(File file){
	    if(file==null){
		return;
	    }
	    if(file.isFile()){
		filePaths.add(file.getPath());
		fileNames.add(file.getName());
	    }else{
		File[] fs=file.listFiles();
		for(File f:fs){
		    searchFiles(f);
		}
	    }
	}
	
	/**
	 * 搜索跟目录下所有文件存到缓存
	 */
	public void searchAllFiles(){
	    searchFiles(srcFileDir);
	}
	
	
   
}

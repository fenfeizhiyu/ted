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
	 * �����ļ�·��
	 */
	private List<String> filePaths=new ArrayList<String>();
	/**
	 * �����ļ�����
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
	 * ��ʼ��һ����Ŀ¼
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
	 * ������Ŀ¼�������ļ��浽����
	 */
	public void searchAllFiles(){
	    searchFiles(srcFileDir);
	}
	
	
   
}

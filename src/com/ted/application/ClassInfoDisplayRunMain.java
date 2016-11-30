package com.ted.application;

import java.util.List;

import com.ted.cache.CacheInterface;
import com.ted.cache.CacheRuner;
import com.ted.cache.ClassInfoCache;
import com.ted.model.ClassInfo;
import com.ted.resource.FileOperation;

public class ClassInfoDisplayRunMain {

	public static void main(String[] args) {
		String loadPath="D:\\log\\classCache2";
		String loadFileName="spring-beans.txt";
		//String[] strs=new String[]{"C:\\\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-aspects","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-beans","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-beans-groovy","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-context","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-context-support","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-core","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-expression","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-framework-bom","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-instrument","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-instrument-tomcat","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-jdbc","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-jms","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-messaging","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm-hibernate4","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-orm-hibernate5","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-oxm","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-test","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-tx","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-web","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc-portlet","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-webmvc-tiles2","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\spring-websocket","C:\\Users\\yu.yang\\Downloads\\spring-framework-4.2.5.RELEASE\\spring-framework-4.2.5.RELEASE\\src",""};
		//String[] projectNames=new String[]{"spring-aspects","spring-beans","spring-beans-groovy","spring-context","spring-context-support","spring-core","spring-expression","spring-framework-bom","spring-instrument","spring-instrument-tomcat","spring-jdbc","spring-jms","spring-messaging","spring-orm","spring-orm-hibernate4","spring-orm-hibernate5","spring-oxm","spring-test","spring-tx","spring-web","spring-webmvc","spring-webmvc-portlet","spring-webmvc-tiles2","spring-websocket","src",""};
		/**
		 * 加载缓存的文件
		 */
		CacheRuner cr=new CacheRuner(loadPath);
		CacheInterface cif=cr.loadCacheFromDisk(loadFileName);
		ClassInfoCache classInfocache=(ClassInfoCache)cif;
		List<ClassInfo> cisList=classInfocache.getCis();
		StringBuilder sb=new StringBuilder();
		//DataCollector dc=new DataCollector();
		
		for(int i=0;i<cisList.size();i++){
			sb.append("number"+(i+1)+":"+cisList.get(i)+"\r\n");
			//dc.addClassInfo(cisList.get(i).getFullName());
		}
		CacheRuner cache=new CacheRuner("D:\\log\\DataCollector.txt");
		ClassInfoCache cic=new ClassInfoCache();
		
		
		FileOperation.writeStringToFile(sb.toString(),FileOperation.createFile("D:\\log\\", "testPrint.txt"));
		
	}

}

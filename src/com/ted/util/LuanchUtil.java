package com.ted.util;

import com.ted.cache.CacheInterface;
import com.ted.cache.CacheRuner;
import com.ted.cache.ClassInfoCache;

public class LuanchUtil {

	/**
	 * ¼ÓÔØ»º´æÎÄ¼þ
	 * @param loadPath
	 * @param loadFileName
	 * @return
	 */
	public static ClassInfoCache LoadCache(String loadPath,String loadFileName){
		CacheRuner cr=new CacheRuner(loadPath);
		CacheInterface cif=cr.loadCacheFromDisk(loadFileName);
		ClassInfoCache classInfocache=(ClassInfoCache)cif;
		return classInfocache;
	}
}

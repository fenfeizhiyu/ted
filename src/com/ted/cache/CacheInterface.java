package com.ted.cache;

import java.io.Serializable;

/**
 * 序列化接口，用于将不同类型的实例序列化保存
 * @author yu.yang
 *
 */
public interface CacheInterface extends Serializable{

	String getTypeName();
	
	String getSaveFileName();
	
	
	
}

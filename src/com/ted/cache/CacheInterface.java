package com.ted.cache;

import java.io.Serializable;

/**
 * ���л��ӿڣ����ڽ���ͬ���͵�ʵ�����л�����
 * @author yu.yang
 *
 */
public interface CacheInterface extends Serializable{

	String getTypeName();
	
	String getSaveFileName();
	
	
	
}

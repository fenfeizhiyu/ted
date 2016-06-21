package com.ted.cache;

import java.util.List;

import com.ted.model.ClassInfo;


/**
 * 用于将一组类信息序列化保存
 * @author yu.yang
 *
 */
public class ClassInfoCache implements CacheInterface{

	
	private static final long serialVersionUID = 3320647997726295844L;
  
	
	
	private List<ClassInfo> cis;
	
	
	private String pojectName;
	
	private String saveName;
	
	private String saveDate;

	
	public String getPojectName() {
		return pojectName;
	}

	public void setPojectName(String pojectName) {
		this.pojectName = pojectName;
	}

	

	public String getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(String saveDate) {
		this.saveDate = saveDate;
	}

	public List<ClassInfo> getCis() {
		return cis;
	}

	public void setCis(List<ClassInfo> cis) {
		this.cis = cis;
	}

	@Override
	public String getTypeName() {
		return "com.ted.cache.ClassInfoCache";
	}

	@Override
	public String getSaveFileName() {
		return saveName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	
}

package com.ted.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollector implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private List<String> classNameCollector;
	private Map<Integer,Integer> classCountMap;
	
	
	public DataCollector(){
		classNameCollector=new ArrayList<String>();
		classCountMap=new HashMap<Integer,Integer>();
	}
	
	public void addClassInfo(String name){
		this.classNameCollector.add(name);
	}
	
	public boolean hasClassName(String name){
		for(String s:classNameCollector){
			if(s.equals(name))
				return true;
		}
		return false;
	}
	
	public void addToClassCountMap(int classId){
		Integer count=(Integer)classCountMap.get(classId);
		if(count==null)
			count=new Integer(1);
		else
			count++;
		classCountMap.put(classId, count);
	}
}

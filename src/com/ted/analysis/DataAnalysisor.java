package com.ted.analysis;

import java.util.List;

import com.ted.model.ClassInfo;

public class DataAnalysisor {

		public void analyClassInfo(List<ClassInfo> classInfos){
			for(int i=0;i<classInfos.size();i++){
				classInfos.get(i).getImportName();
				
			}
		}
		
		
}

package com.ted.search;

public interface DoTask {
	
	
	
	boolean preDo(DataHolder dataHolder);
	boolean doTask(DataHolder dataHolder);
	boolean afterDo(DataHolder dataHolder);
}

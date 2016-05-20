package com.ted.resource;

import com.ted.constant.ResourceConstant;


public class DirtyInfo {

	/**
	 * 包含开始符的起始位置
	 */
	private int startIndex=-1;
	
	/**
	 * 不包含结束符的结束位置
	 */
	private int endIndex=-1;
	
	private int startFlag;
	
	private int[] startWords;
	
	private int endFlag;
	
	private int[] endWords;
	
	/**
	 * 指定开始字符，开始字符串，结束字符，结束字符串
	 * @param startFlag
	 * @param startWords
	 * @param endFlag
	 * @param endWords
	 */
	public DirtyInfo(int startFlag,int[] startWords,int endFlag,int[] endWords){
		this.startFlag=startFlag;
		this.startWords=startWords;
		this.endFlag=endFlag;
		this.endWords=endWords;
	}
	
	/***
	 * 指定开始字符，开始字符串，默认结束字符为回车换行符。
	 * @param startFlag
	 * @param startWords
	 */
	public DirtyInfo(int startFlag,int[] startWords){
		this.startFlag=startFlag;
		this.startWords=startWords;
		this.endFlag=ResourceConstant.huiche;
		this.endWords=new int[]{endFlag,ResourceConstant.huanhang};
	}
	/**
	 * 判断是否命中开始字符
	 * @param b
	 * @return
	 */
	public boolean isStartFlag(char b){
		return startFlag==(int)b;
	}
	
	/**
	 * 判断是否命中结束字符
	 * @param b
	 * @return
	 */
	public boolean isEndFlag(char b){
		return endFlag==(int)b;
	}
	
	/**
	 * 判断是否是完整的开始字符
	 * @param chars
	 * @return
	 */
	public boolean isStartWords(char[] chars){
		return isEqualWords(this.startWords,chars);
	}
	
	
	/**
	 * 判断是否是完整的结束字符
	 * @param chars
	 * @return
	 */
	public boolean isEndWords(char[] chars){
		return isEqualWords(this.endWords,chars);
	}
	
	private boolean isEqualWords(int[] words,char[] chars){
		for(int i=0;i<chars.length;i++){
			if(chars[i]!=words[i])
				return false;
		}
		return true;
	}
	
	public int getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(int startFlag) {
		this.startFlag = startFlag;
	}

	public int[] getStartWords() {
		return startWords;
	}

	public void setStartWords(int[] startWords) {
		this.startWords = startWords;
	}

	public int getEndFlag() {
		return endFlag;
	}

	public void setEndFlag(int endFlag) {
		this.endFlag = endFlag;
	}

	public int[] getEndWords() {
		return endWords;
	}

	public void setEndWords(int[] endWords) {
		this.endWords = endWords;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	
	
	
	
	
	
}

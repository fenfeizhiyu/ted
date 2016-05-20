package com.ted.resource;

import com.ted.constant.ResourceConstant;


public class DirtyInfo {

	/**
	 * ������ʼ������ʼλ��
	 */
	private int startIndex=-1;
	
	/**
	 * �������������Ľ���λ��
	 */
	private int endIndex=-1;
	
	private int startFlag;
	
	private int[] startWords;
	
	private int endFlag;
	
	private int[] endWords;
	
	/**
	 * ָ����ʼ�ַ�����ʼ�ַ����������ַ��������ַ���
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
	 * ָ����ʼ�ַ�����ʼ�ַ�����Ĭ�Ͻ����ַ�Ϊ�س����з���
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
	 * �ж��Ƿ����п�ʼ�ַ�
	 * @param b
	 * @return
	 */
	public boolean isStartFlag(char b){
		return startFlag==(int)b;
	}
	
	/**
	 * �ж��Ƿ����н����ַ�
	 * @param b
	 * @return
	 */
	public boolean isEndFlag(char b){
		return endFlag==(int)b;
	}
	
	/**
	 * �ж��Ƿ��������Ŀ�ʼ�ַ�
	 * @param chars
	 * @return
	 */
	public boolean isStartWords(char[] chars){
		return isEqualWords(this.startWords,chars);
	}
	
	
	/**
	 * �ж��Ƿ��������Ľ����ַ�
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

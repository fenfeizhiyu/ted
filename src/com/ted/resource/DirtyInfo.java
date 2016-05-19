package com.ted.resource;


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
	
	
	public boolean isStartFlag(byte b){
		return startFlag==(int)b;
	}
	
	public boolean isEndFlag(byte b){
		return endFlag==(int)b;
	}
	
	/**
	 * �ж��Ƿ��������Ŀ�ʼ�ַ�
	 * @param bytes
	 * @return
	 */
	public boolean isStartWords(byte[] bytes){
		return isEqualWords(this.startWords,bytes);
	}
	
	
	/**
	 * �ж��Ƿ��������Ľ����ַ�
	 * @param bytes
	 * @return
	 */
	public boolean isEndWords(byte[] bytes){
		return isEqualWords(this.endWords,bytes);
	}
	
	private boolean isEqualWords(int[] words,byte[] bytes){
		for(int i=0;i<bytes.length;i++){
			if(bytes[i]!=words[i])
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

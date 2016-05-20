package com.ted.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ted.constant.ResourceConstant;

/**
 * ���Դ�ļ��е�ע�⣬��б��ע��
 * @author yu.yang
 *
 */
public class CleanClassSourceByChar {
	
	private String sourceStr;
	
	private char[] sourceStrChars;
	
	private List<DirtyInfo> dirtyInfos=new ArrayList<DirtyInfo>();
	
	
	
	
	public CleanClassSourceByChar(String str){
		this.sourceStr=str;
		this.sourceStrChars=str.toCharArray();
	}
	
	public CleanClassSourceByChar(char[] chars){
		this.sourceStrChars=chars;
	}
	
	
	
	public void addDirtyInfo(DirtyInfo di){
		this.dirtyInfos.add(di);
	}
	
	public String getSourceStr() {
		return sourceStr;
	}

	public void setSourceStr(String sourceStr) {
		this.sourceStr = sourceStr;
	}

	public char[] getSourceStrChars() {
		return sourceStrChars;
	}

	public void setSourceStrChars(char[] sourceStrChars) {
		this.sourceStrChars = sourceStrChars;
	}

	
	
	public char[] doClean(){
		return iteratorSourceByChar();
	}
	
	public char[]  iteratorSourceByChar(){
		for(int i=0;i<sourceStrChars.length;i++){
			//�ж�������Ҫ����Ŀ�ʼ�ַ�
			DirtyInfo di=iteratorDirtyInfoStartFlag(sourceStrChars[i]);
			if(di!=null){
				di.setStartIndex(i);
				//�����е㿪ʼȡ����ָ����ʼ�ַ���������ȵ��ַ����������е㣩
				char[] startChars=getcharsByNum(i,di.getStartWords().length);
				//�ж��Ƿ�����Ҫ��������п�ʼ�ַ���
				if(di.isStartWords(startChars)){
					//���ҽ���λ��
					searchEnd(di,i+di.getStartWords().length-1);
					if(di.getEndIndex()!=-1)
						this.replaceWords(di);
						//�ض�λ����ָ��
						i=di.getEndIndex();
				}
			}
			
		}
		return sourceStrChars;
	}
	
	/**
	 * �ж��Ƿ�����Ҫȥ���Ŀ�ʼ�ַ�
	 * @param b
	 * @return
	 */
	private DirtyInfo iteratorDirtyInfoStartFlag(char b){
		for(DirtyInfo di:dirtyInfos){
			if(di.isStartFlag(b)){
				return di;
			}
		}
		return null;
	}
	
	/**
	 * ��ȡָ�����ȵ��ֽ�
	 * @param start
	 * @param num
	 * @return
	 */
	private char[] getcharsByNum(int start,int num){
		char[] reChar=new char[num];
		for(int i=0;i<num;i++){
			reChar[i]=this.sourceStrChars[start+i];
		}
		return reChar;
	}
	
	/**
	 * ����������
	 * @param di
	 * @param index
	 */
	private void searchEnd(DirtyInfo di,int index){
		for(int i=index;i<this.sourceStrChars.length;i++){
			//�ж��Ƿ����н����ַ�
			if(di.isEndFlag(sourceStrChars[i])){
				//�����е㿪ʼȡ����ָ�������ַ���������ȵ��ַ����������е㣩
				char[] endChars=getcharsByNum(i,di.getEndWords().length);
				if(di.isEndWords(endChars)){
					di.setEndIndex(i-1);
				}
			}
		}
	}
	
	
	/**
	 * ��Ҫ������ַ��滻Ϊ�ո��,�Ӱ�����ʼ�ַ���λ�ÿ�ʼ���������������ַ���λ��
	 */
	private void replaceWords(DirtyInfo di){
		for(int i=di.getStartIndex();i<di.getEndIndex()+1;i++){
			this.sourceStrChars[i]=ResourceConstant.kongge;
		}
	}
	
	
	
	
}

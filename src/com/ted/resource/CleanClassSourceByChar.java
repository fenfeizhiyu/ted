package com.ted.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ted.constant.ResourceConstant;

/**
 * 清除源文件中的注解，反斜杠注释
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
			//判断是命中要清除的开始字符
			DirtyInfo di=iteratorDirtyInfoStartFlag(sourceStrChars[i]);
			if(di!=null){
				di.setStartIndex(i);
				//从命中点开始取出和指定开始字符串长度相等的字符（包含命中点）
				char[] startChars=getcharsByNum(i,di.getStartWords().length);
				//判断是否命中要清除的所有开始字符串
				if(di.isStartWords(startChars)){
					//查找结束位置
					searchEnd(di,i+di.getStartWords().length-1);
					if(di.getEndIndex()!=-1)
						this.replaceWords(di);
						//重定位遍历指针
						i=di.getEndIndex();
				}
			}
			
		}
		return sourceStrChars;
	}
	
	/**
	 * 判断是否命中要去除的开始字符
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
	 * 截取指定长度的字节
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
	 * 搜索结束符
	 * @param di
	 * @param index
	 */
	private void searchEnd(DirtyInfo di,int index){
		for(int i=index;i<this.sourceStrChars.length;i++){
			//判断是否命中结束字符
			if(di.isEndFlag(sourceStrChars[i])){
				//从命中点开始取出和指定结束字符串长度相等的字符（包含命中点）
				char[] endChars=getcharsByNum(i,di.getEndWords().length);
				if(di.isEndWords(endChars)){
					di.setEndIndex(i-1);
				}
			}
		}
	}
	
	
	/**
	 * 将要清除的字符替换为空格符,从包括开始字符的位置开始，到不包括结束字符的位置
	 */
	private void replaceWords(DirtyInfo di){
		for(int i=di.getStartIndex();i<di.getEndIndex()+1;i++){
			this.sourceStrChars[i]=ResourceConstant.kongge;
		}
	}
	
	
	
	
}

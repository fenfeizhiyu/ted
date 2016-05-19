package com.ted.resource;

import java.util.Arrays;
import java.util.List;

import com.ted.constant.ResourceConstant;

/**
 * 清除源文件中的注解，反斜杠注释
 * @author yu.yang
 *
 */
public class CleanClassSource {
	
	private String sourceStr;
	
	private byte[] sourceStrBytes;
	
	private List<DirtyInfo> dirtyInfos;
	
	
	
	
	public CleanClassSource(String str){
		this.sourceStr=str;
	}
	
	public CleanClassSource(byte[] bytes){
		this.sourceStrBytes=bytes;
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

	public byte[] getSourceStrBytes() {
		return sourceStrBytes;
	}

	public void setSourceStrBytes(byte[] sourceStrBytes) {
		this.sourceStrBytes = sourceStrBytes;
	}

	public void  iteratorSourceByByte(){
		for(int i=0;i<sourceStrBytes.length;i++){
			//判断是命中要清除的开始字符
			DirtyInfo di=iteratorDirtyInfoStartFlag(sourceStrBytes[i]);
			if(di!=null){
				di.setStartIndex(i);
				byte[] startBytes=getbytesByNum(i,di.getStartWords().length);
				//判断是否命中要清除的所有开始字符串
				if(di.isStartWords(startBytes)){
					//查找结束位置
					searchEnd(di,i+di.getStartWords().length-1);
					if(di.getEndIndex()!=-1)
						this.doClean(di);
				}
			}
			
		}
	}
	
	/**
	 * 判断是否命中要去除的开始字符
	 * @param b
	 * @return
	 */
	public DirtyInfo iteratorDirtyInfoStartFlag(byte b){
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
	private byte[] getbytesByNum(int start,int num){
		byte[] reByte=new byte[num];
		for(int i=0;i<num;i++){
			reByte[i]=this.sourceStrBytes[start+i];
		}
		return reByte;
	}
	
	/**
	 * 搜索结束符
	 * @param di
	 * @param index
	 */
	private void searchEnd(DirtyInfo di,int index){
		for(int i=index;i<this.sourceStrBytes.length;i++){
			if(di.isEndFlag(sourceStrBytes[i])){
				byte[] endBytes=getbytesByNum(i,di.getEndWords().length);
				if(di.isEndWords(endBytes)){
					di.setEndIndex(i-1);
				}
			}
		}
	}
	
	
	/**
	 * 将要清除的字符替换为空格符
	 */
	private void doClean(DirtyInfo di){
		for(int i=di.getStartIndex();i<di.getEndIndex()+1;i++){
			this.sourceStrBytes[i]=ResourceConstant.kongge;
		}
	}
	
	
	
	
}

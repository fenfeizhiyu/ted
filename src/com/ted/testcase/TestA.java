package com.ted.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestA {
	private static Object lock=new Object();
	private static int init=40;
	private static TestA.StackMsg msg=new TestA.StackMsg();
	public static void main(String[] args) {
		Executor executor=Executors.newFixedThreadPool(5);
		for(int i=0;i<init;i++){
			msg.push("msg: "+i);
		}
		
		
		for(int i=0;i<6;i++){
			executor.execute(new Runnable(){
				@Override
				public void run() {
					while(true){
						synchronized (lock) {
							System.out.println(Thread.currentThread().getName()+": do");
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
				}
				
			});
		}
		
		for(int i=init;i<init+50;i++){
			msg.push("msg: "+i);
		}

	}
	
	
	
	public static class StackMsg{
		private int i=0;
		List<String> msgList=new ArrayList<String>();
		
		public void push(String msg){
			msgList.add(msg);
			i++;
		}
		
		public String pop(){
			return msgList.get(i--);
		}
		
	}

}

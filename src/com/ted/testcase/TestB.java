package com.ted.testcase;

import java.util.LinkedList;

public class TestB {
	
	private static Object obj=new Object();
	private static Thread[] ths;
	private static   LinkedList<Long> lList = new LinkedList<Long>();  
	private static int count=30;
	public static void main(String[] args) throws InterruptedException{
		Runnable task=new Runnable(){

			@Override
			public void run() {
				System.out.println("start");
				try {
					while(count>0){
						System.out.println(Thread.currentThread().getName()+" waiting for obj");
						synchronized(obj){
							//obj.wait();
							String name=Thread.currentThread().getName();
							long start=System.currentTimeMillis();
							System.out.println(name+" doing for obj");
							long i=0;
							for(i=0;i<3000000000L;i++){
								
							}
							long time=System.currentTimeMillis()-start;
							lList.add(time);
							System.out.println(i);
							System.out.println(name+" done "+(time));
							count--;
						}
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true){
					System.out.println(Thread.currentThread().getName()+" quit");
					try {
						Thread.sleep(1000*1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		ths=new Thread[2];
		for(int i=0;i<ths.length;i++){
			ths[i]=new Thread(task,"name"+i);
		}
		for(Thread th:ths){
			th.start();
		}
		while(true){
			Thread.sleep(1000*1);
			for(Thread th:ths){
				System.out.println(th.getName()+" :"+th.getState());
			}
			System.out.println("****************"+count);
			if(count>0){
				long sum=0;
				for(long s:lList){
					sum=sum+s;
				}
				System.out.println("avrage time is "+(sum/lList.size()));
			}
		}
		
	}

}

package com.demo.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {
	public Integer count=0;
	public static void main(String[] args) {
		final Demo demo=new Demo();
		Executor executor=Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			executor.execute(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					demo.count++;
				}
				
			});
		}
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("final count value "+demo.count);
	}
}

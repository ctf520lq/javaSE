package com.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Thread()) ;
		System.out.println("*****召唤神龙");
		
		for(int i = 1;i <= 7;i++) {
			final int tempInt = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"\t 收集到第:"+ tempInt+"龙珠");
					try {
						cyclicBarrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			
		}
	}
}

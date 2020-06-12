package com.Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo{

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		for(int i = 1;i<=6;i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"\t**"+"\t国,被灭!");
					countDownLatch.countDown();
//					Long count = countDownLatch.getCount();
//					System.out.println("计数器:"+count);
				}
			});
			thread.start();
			System.out.println(CountTryEnum.forEach_CountryEnum(i).getRetMessage());
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t ****秦统一六国");
	}

}

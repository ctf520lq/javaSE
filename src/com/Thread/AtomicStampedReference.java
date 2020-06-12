package com.Thread;
/**
 * 带时间戳的原子类
 * @author Administrator
 *
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicStampedReference {

	static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
	static java.util.concurrent.atomic.AtomicStampedReference<Integer> at = new java.util.concurrent.atomic.AtomicStampedReference<Integer>(100, 1);
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				atomicReference.compareAndSet(100, 101);
				atomicReference.compareAndSet(101, 100);
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int stap = at.getStamp();
				System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+stap);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				at.compareAndSet(100, 101, stap, stap+1);
				System.out.println(Thread.currentThread().getName()+"\t第二次版本号"+stap);
				at.compareAndSet(101, 100, stap, stap+1);
				System.out.println(Thread.currentThread().getName()+"\t第三次版本号"+stap);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int stap = at.getStamp();
				System.out.println(Thread.currentThread().getName()+"\t第二次版本号"+stap);
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean result= at.compareAndSet(100, 2019, stap, stap+1);
				System.out.println(Thread.currentThread().getName()+"\t最新版本号"+result);
			}
		}).start();
	}
	
}

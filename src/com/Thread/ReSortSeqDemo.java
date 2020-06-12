package com.Thread;

public class ReSortSeqDemo{

	int a = 0;
	boolean flag = false;
	
	public void method01() {
		a = 1;
		flag = true;
	}
	public void method02() {
		if(flag) {
			a = a + 5;
			System.out.println("******"+a);
		}
	}
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ReSortSeqDemo r = new ReSortSeqDemo();
				r.method01();
				r.method02();
				
			}
		}).start();
	}
}

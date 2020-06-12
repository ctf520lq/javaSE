package com.Thread;

public class SingleDeom {

	//volatile禁止指令重排
	private static volatile SingleDeom s = null;
	
	private SingleDeom() {
		System.out.println(Thread.currentThread().getName()+":我是构造方法!");
	}
	
	//DCL(双端检锁机制)
	public static SingleDeom getSingleDeom() {
		if(s == null) {
			synchronized (SingleDeom.class) {
				if(s == null) {
					s = new SingleDeom();
				}
			}
		}
		return s;
	}
	public static void main(String[] args) {
//		System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
//		System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
//		System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
					System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
					System.out.println(SingleDeom.getSingleDeom() == SingleDeom.getSingleDeom());
				}
			}).start();
		}
		
	}
	
}

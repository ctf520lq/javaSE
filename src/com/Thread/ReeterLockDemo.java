package com.Thread;


class Phone{
	public synchronized void sendSMS() {
		System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS");
		sendEmail();
	}
	
	public synchronized void sendEmail() {
		System.out.println(Thread.currentThread().getId()+"\t invoked sendEmail");
	}
}

public class ReeterLockDemo {

	public static void main(String[] args) {
		Phone phone = new Phone();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				phone.sendSMS();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				phone.sendSMS();
			}
		}).start();
		
	}
}

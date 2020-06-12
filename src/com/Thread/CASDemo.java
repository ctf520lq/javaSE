package com.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas compareAndSet 比较并交换
 * @author Administrator
 *
 */
public class CASDemo {

	public static void main(String[] args) {
		// 创建一个原子类
		AtomicInteger atomicInteger = new AtomicInteger(5);
		/**
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是5，也就是expect为5，然后我需要更新成 2019
         */
		System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current date:"+atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5, 2020)+"\t current date:"+atomicInteger.get());
		atomicInteger.getAndIncrement();
		
		/*
		 *  true	 current date:2019
			false	 current date:2019

		 */
	}
}

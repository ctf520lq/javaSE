package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		//List<String> list =  new ArrayList<>();
		//List<String> list = Collections.synchronizedList(new ArrayList<>());
		//List<String> list = new CopyOnWriteArrayList<>();
		Set<String> set = Collections.synchronizedSet(new HashSet<>());
		for (int i = 0; i < 30; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					set.add(UUID.randomUUID().toString().substring(0,8));
					System.out.println(set); 
				}
			}).start();
		}
	}
}

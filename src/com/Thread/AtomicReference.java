package com.Thread;

class User{
	String userName;
	int age;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + "]";
	}
	
	
}
/**
 * 原子引用AtomicReference,解决ABA问题.
 * @author Administrator
 *
 */
public class AtomicReference {

	public static void main(String[] args) {
		User u1 = new User("chentf",22);
		User u2 = new User("liuqong", 24);
		java.util.concurrent.atomic.AtomicReference<User> atomicReference = new java.util.concurrent.atomic.AtomicReference<User>();
		atomicReference.set(u1);
		System.out.println(atomicReference.compareAndSet(u1, u2)+"\t"+atomicReference.get().toString());
		System.out.println(atomicReference.compareAndSet(u1, u2)+"\t"+atomicReference.get().toString());
	}
}

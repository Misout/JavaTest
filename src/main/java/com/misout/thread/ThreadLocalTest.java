package com.misout.thread;

public class ThreadLocalTest {
	public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	
	static class SubThread extends Thread {
		
		public SubThread() {
			super();
		}
		
		public SubThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			threadLocal.set(getName());
			
			System.out.println(threadLocal.get());
		}
	}
	
	public static void main(String[] args) {
		SubThread t1 = new SubThread("misout-thread-t1");
		SubThread t2 = new SubThread("misout-thread-t2");
		t1.start();
		t2.start();
	}
}

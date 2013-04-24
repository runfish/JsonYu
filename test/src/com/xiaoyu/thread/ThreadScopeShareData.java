package com.xiaoyu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {

	/**
	 * @param args
	 */

	private final static Map<Thread, Integer> map = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ "put data into data" + data);
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
					new C().get();

				}

			}).start();
		}

	}

	static class A {
		private int get() {

			int data = map.get(Thread.currentThread());

			System.out.println("from A" + Thread.currentThread().getName()+"   "+data);

			return data;

		}
	}

	static class B {
		private int get() {
			int data = map.get(Thread.currentThread());
			
			System.out.println("from A" + Thread.currentThread().getName()+"   "+data);			
			return data;
			// TODO Auto-generated method stub

		}
	}

	static class C {
		private int get() {
			int data = map.get(Thread.currentThread());
			
			System.out.println("from A" + Thread.currentThread().getName()+"   "+data);			
			return data;
			// TODO Auto-generated method stub

		}
	}

}

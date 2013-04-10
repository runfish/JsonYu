package com.xiaoyu.test;

public class InnerClassDemo3 {

	public static void main(String[] args) {
		new Outer3().method(12);
	}

}

class Outer3 {

	int num = 3;

	void method(final int y) {

		final int x = 12;
		class Inner {

			void show() {
				System.out.println("方法里面的内部类" + x+""+y);
			}

		}
		Inner inner = new Inner();
		inner.show();

	}

}

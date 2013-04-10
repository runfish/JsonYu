package com.xiaoyu.test;



public class InnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.getInner();
	//	Outer.Inner inner = new Outer().new Inner();
		/**
		 * 外部类名.内部类名   句柄  =  外部类对象.内部类对象
		 * 
		 */
	//	inner.show();
		
		Outer.Inner inner = new Outer.Inner();
		inner.show();
		
		Outer.Inner.show();
	}
}

class Outer{
	
	private int num = 10;
	
	static class Inner{
		static void show(){
			System.out.println("内部类方法....");
		}
	}
	
	public void getInner() {
		Inner inner = new Inner();
		inner.show();
	}
	
}
package com.xiaoyu.test;

public class InnerClassdemo2 {
	
	public static void main(String[] args) {
		
		Outer1.Inner inner = new Outer1().new Inner();
		inner.show();
	}

}

class Outer1{
	
	int num=3;
	
	class Inner{
		//int num = 4;
		
		void show(){
		//	int num = 5;
			System.out.println(num);
		//	System.out.println(this.num);
			System.out.println(Outer1.this.num);
		}
	}
}

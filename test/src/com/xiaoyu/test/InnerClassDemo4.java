package com.xiaoyu.test;

public class InnerClassDemo4 {
	
	public static void main(String[] args) {
		Outer4 outer4 = new Outer4();
		
		outer4.method();
	}

}

class Outer4{
	int num = 32;
//	class Inner extends Demo{
//		
//		void show(){
//			System.out.println("   ....."+num);
//		}
//	}
	public void method() {

       new Demo(){
    	   void show(){
    		   System.out.println("。。。。。。。"+num);
    	   }
       }.show();
	}
	
}

abstract class Demo{
	
	abstract void show();
	
	
}

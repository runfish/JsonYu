package com.xiaoyu.thread;

public class Face2 {

	public static void main(String[] args) {
		ShareData shareData = new ShareData();
		Thread t1 = new Thread(new MyRunnable1(shareData));
		Thread t2 = new Thread(new MyRunnable1(shareData));
		Thread t3 = new Thread(new MyRunnable2(shareData));
		Thread t4 = new Thread(new MyRunnable2(shareData));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class MyRunnable1 implements Runnable{

	private ShareData shareData;
	public MyRunnable1(ShareData shareData){
		this.shareData = shareData;
	}
	public void run() {
		// TODO Auto-generated method stub
		shareData.add();
		
	}
	
}
class MyRunnable2 implements Runnable{
	
	private ShareData shareData;
	public MyRunnable2(ShareData shareData){
		this.shareData = shareData;
	}
	public void run() {
		// TODO Auto-generated method stub
		shareData.minus();
		
	}
	
}

class ShareData{
	
	int j=0;
	
	public synchronized void add(){
		j++;
	System.out.println("加"+Thread.currentThread().getName()+j);
	}
	
	public synchronized void minus(){
		j--;
		System.out.println("减"+Thread.currentThread().getName()+j);
	}
	
	
}
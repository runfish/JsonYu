package com.xiaoyu.thread;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TraditionTimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new 一个定时器
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bomoing");
			}
			
			
			
		}, 10000,3000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

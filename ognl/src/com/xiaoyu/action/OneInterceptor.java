package com.xiaoyu.action;

import com.xiaoyu.util.BaseAction;

public class OneInterceptor extends BaseAction{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("XXXXXXXX");
		return "succ";
	}

}

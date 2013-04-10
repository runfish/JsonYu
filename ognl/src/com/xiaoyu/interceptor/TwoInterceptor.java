package com.xiaoyu.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class TwoInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("执行拦截器2方法");
		long begin = System.currentTimeMillis();
		System.out.println("方法拦截2之前");
		String executeResult = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println(begin-end);
		System.out.println("方法拦截2之后");
		System.out.println(executeResult);
		
		return executeResult;
	}


	

}

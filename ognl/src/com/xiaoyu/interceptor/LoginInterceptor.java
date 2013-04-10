package com.xiaoyu.interceptor;

import java.util.Map;

import oracle.net.aso.a;

import org.apache.struts2.views.xslt.MapAdapter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xiaoyu.action.LoginAction;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext actionContext = invocation.getInvocationContext();
		

		Map<String, Object> mapsession = actionContext.getSession();
		
		Object aObject = invocation.getAction();
		
		String resultStr = "";
		
		String message = "";
		
		if (aObject instanceof LoginAction) {
			LoginAction loginAction = (LoginAction) aObject;
			resultStr = invocation.invoke();
		}
		else{
			if(mapsession.get("username")==null){
				
				System.out.println("登陆超时 请重新登陆");
				resultStr = "goto_login";
				
				actionContext.put("message", message);
			}
			else{
				System.out.println("登陆成功！");
				resultStr = invocation.invoke();
			}
		}
		return resultStr;
	}

}

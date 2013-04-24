package com.dp.interceptor;

import java.util.Map;

import com.dp.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = invocation.getInvocationContext();

		Map<String, Object> sessionMap = actionContext.getSession();

		Object objectAction = invocation.getAction();

		String message = "";

		String result = "";

		if (objectAction instanceof LoginAction) {
			result = invocation.invoke();
		} else {
			if (sessionMap.get("username") == null) {
				result = "goto_login";
				message = "你还未登录..请登录";
				actionContext.put("message", message);
			} else {

				result = invocation.invoke();

			}

		}

		return result;
	}

}

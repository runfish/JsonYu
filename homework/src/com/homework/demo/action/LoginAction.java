package com.homework.demo.action;

import java.util.Map;


import com.homework.demo.utils.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {

	private String username;
	
	private String password;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> sessionMap = actionContext.getSession();
		String message ="";
		String result = "";
		
		if(this.username.equals("admin")){
			if(this.password.equals("xiaoyu")){
				result = "succ";
				sessionMap.put("username", username);
				sessionMap.put("password", password);
				
			}else{
				
				message = "登录密码错误，请重新登录";
				result="error";
			}
			
		}else{
			message="用户名错误，请重新登录！";
			result = "error";
		}
		actionContext.put("message", message);
		

		return result;
	}

}

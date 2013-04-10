package com.xiaoyu.action;

import java.util.Map;

import oracle.net.aso.a;

import com.opensymphony.xwork2.ActionContext;
import com.xiaoyu.util.BaseAction;

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
		Map<String,Object> session = actionContext.getSession();
		String message = "";
		String result = "";
		
		if(username.equals("xiaoyu")){
			if(password.equals("xiaoyu")){
				session.put("username", this.username);
				session.put("password", this.password);
				result = "succ";
			}
			else{
				message="密码错误！";
				result = "error";
			}
			
		}
		else{
			message = "用户名不正确";
			result ="error";
			
		}
		
		actionContext.put("message", message);
		
		return result;
	}

}

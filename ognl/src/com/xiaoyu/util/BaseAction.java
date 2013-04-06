package com.xiaoyu.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, ServletContextAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected PrintWriter out;
	protected ServletContext servletContext;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		if (this.request != null) {
			this.session = request.getSession();
		}
	}

	public void setServletResponse(HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		this.response = response;
		if (this.response != null) {
			try {
				this.out = this.response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public abstract String execute() throws Exception;
}

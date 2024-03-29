package com.xiaoyu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xiaoyu.util.BaseAction;

public class FormAction extends BaseAction {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.username = "xiaoyu";

		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();

		map1.put("classid", 1);
		map1.put("classname", "手机");
		map2.put("classid", 2);
		map2.put("classname", "电脑");
		map3.put("classid", 3);
		map3.put("classname", "三星");
		map4.put("classid", 4);
		map4.put("classname", "诺基亚");
		
		maplist.add(map1);
		maplist.add(map2);
		maplist.add(map3);
		maplist.add(map4);
		
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("classList", maplist);

		return this.SUCCESS;
	}

}

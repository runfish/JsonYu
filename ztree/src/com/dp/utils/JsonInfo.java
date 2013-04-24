package com.dp.utils;

import java.io.Serializable;

public class JsonInfo implements Serializable {
	private boolean flag;

	private String message;

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

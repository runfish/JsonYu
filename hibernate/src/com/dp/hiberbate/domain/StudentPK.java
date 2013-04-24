package com.dp.hiberbate.domain;

import java.io.Serializable;

public class StudentPK implements Serializable{
	
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof StudentPK){
			StudentPK spk = (StudentPK) obj;
			if(this.id==spk.getId()&&this.name.equals(spk.getName()))
				return true;
			
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	
	
	

}

package com.dp.hiberbate.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator( name ="lh" , sequenceName="xiaoyu")
public class Teacher {
	
	private static final String xiaoyu = null;

	private int id;
	
	private String title;
	
	private String name;
	
	private Date birthDay;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lh")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//@Transient
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Column(length=20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
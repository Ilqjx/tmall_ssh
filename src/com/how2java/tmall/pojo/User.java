package com.how2java.tmall.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAnonymousName() {
		if (name == null) {
			return null;
		}
		int length = name.length();
		if (length <= 1) {
			return "*";
		} else if (length == 2) {
			return name.charAt(0) + "*";
		} else {
			String anonymousName = name.charAt(0) + "";
			for (int i = 1; i <= length - 2; i++) {
				anonymousName += "*";
			}
			anonymousName += name.charAt(length-1);
			return anonymousName;
		}
	}
	
}

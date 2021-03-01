package com.duhan.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {
	@Id
	private int sid;
	
	@Column(nullable = false)
	private String sname;
    private int roll_no;
    
    @Transient
    private String isMarried;
    private String wife_name;
    private String wife_age;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}
	
	public String getWife_name() {
		return wife_name;
	}
	public void setWife_name(String wife_name) {
		this.wife_name = wife_name;
	}
	public String getWife_age() {
		return wife_age;
	}
	public void setWife_age(String wife_age) {
		this.wife_age = wife_age;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", roll_no=" + roll_no + ", isMarried=" + isMarried
				+ ", wife_name=" + wife_name + ", wife_age=" + wife_age + "]";
	}
    
}

package com.blogback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Studentizuser")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@Column(unique=true,nullable=false)
	private	String uname;
	@Column(unique=true,nullable=false)
	private	String email ;
	private	String dob;
	@Column(nullable=false)
	private String pwrd;
	@Transient
	private	String repwrd;
	private String role;
	@Column(name="skls")
	private String skls;
	@Column(name="enable")
	private int enable;
	@Column(name="isonline")
	private int isOnline;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwrd() {
		return pwrd;
	}
	public void setPwrd(String pwrd) {
		this.pwrd = pwrd;
	}
	public String getRepwrd() {
		return repwrd;
	}
	public void setRepwrd(String repwrd) {
		this.repwrd = repwrd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSkls() {
		return skls;
	}
	public void setSkls(String skls) {
		this.skls = skls;
	}
	public int isEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int isOnline() {
		return isOnline;
	}
	public void setOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	@Override
	public String toString() {
		return this.uname + " " + this.email + " " + this.role + "\n";
	}
	
}
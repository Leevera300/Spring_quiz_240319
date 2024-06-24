package com.quiz.lesson05.domain;

import java.time.LocalDate;

public class Member {
	private int id;
	private String Name;
	private String PhoneNumber;
	private String Email;
	private String Nationality;
	private String Introduce;
	private LocalDate Birth;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getIntroduce() {
		return Introduce;
	}
	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}
	public LocalDate getBirth() {
		return Birth;
	}
	public void setBirth(LocalDate birth) {
		Birth = birth;
	}
	
	
}

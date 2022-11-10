package com.Spring.Assignment.Vaccine.Vaccine.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PERSON {

	@Id
	@Column(name="PANID")
	private int panID;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="AGE")
	private int age;
	@Column(name="PHONE")
	private int phone;
	@Column(name="EMAIL")
	private String email;

	@OneToOne(targetEntity=HEALTH.class,cascade=CascadeType.ALL)
	@JoinColumn(name="HEALTHID",referencedColumnName="HEALTHID")
	private HEALTH health;

	
 PERSON() {}

	public PERSON(int panID, String firstName, String lastName, String gender, int age, int phone, String email , HEALTH health
		) {
		this.panID = panID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.health=health;
	}
	public int getPanID() {
		return panID;
	}

	public void setPanID(int panID) {
		this.panID = panID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HEALTH getHealth() {
		return health;
	}

	public void setHealthId(HEALTH health) {
		this.health = health;
	}

//	@Override
//	public String toString() {
//		return "PERSON [panID=" + panID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
//				+ ", age=" + age + ", phone=" + phone + ", email=" + email + ", healthId=" + healthId + "]";
//	}
//	
	
}

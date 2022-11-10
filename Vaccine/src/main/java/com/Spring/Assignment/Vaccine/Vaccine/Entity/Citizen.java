package com.Spring.Assignment.Vaccine.Vaccine.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON"  )
@SecondaryTable(name = "HEALTH", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PANID")  )//@javax.persistence.ForeignKey annotation 
public class Citizen{

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



	
	@Column(name="REPORT",table="HEALTH")
	private int report;
	
	
	@Column(name="DOSE1",table="HEALTH")
	private Date dose1;
	@Column(name="DOSE2",table="HEALTH")
	private Date dose2;
	@Column(name="DOSE3",table="HEALTH")
	private Date dose3;
    @Column(name="VACCINETYPE",table="HEALTH")
    private String vactype; 
    @Column(name="STATUS",table="HEALTH")
    private String status; 
    
	
	
 Citizen() {}

	public Citizen(int panID, String firstName, String lastName, String gender, int age, int phone, String email , int report, Date dose1, Date dose2,Date dose3,String vactype
		, String status) {
		this.panID = panID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	
		
	
		this.report=report;
		this.dose1 = dose1;
		this.dose2 = dose2;
		this.dose3=dose3;
		this.vactype = vactype;
		this.status=status;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getDose1() {
		return dose1;
	}

	public void setDose1(Date dose1) {
		this.dose1 = dose1;
	}

	public Date getDose2() {
		return dose2;
	}

	public void setDose2(Date dose2) {
		this.dose2 = dose2;
	}
	public Date getDose3() {
		return dose3;
	}

	public void setDose3(Date dose3) {
		this.dose3 = dose3;
	}
	public String getVactype() {
		return vactype;
	}

	public void setVactype(String vactype) {
		this.vactype=vactype;
	}
	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}



	
}

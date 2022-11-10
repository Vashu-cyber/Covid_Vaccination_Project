package com.Spring.Assignment.Vaccine.Vaccine.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class HEALTH {

	@Id
	@Column(name="HEALTHID")
	private int healthId;

	@OneToOne(targetEntity=STATUS.class,cascade=CascadeType.ALL)
	@JoinColumn(name="report",referencedColumnName="VACSTATUS")
	private STATUS report;
	
	
	@Column(name="DOSE1")
	private Date dose1;
	@Column(name="DOSE2")
	private Date dose2;
	@Column(name="BOOSTERDOSE")
	private Date dose3;
    @Column(name="VACCINETYPE")
    private String vactype;  
 
    
	public HEALTH() {}

	public HEALTH(int healthId, STATUS report, Date dose1, Date dose2,Date dose3,String vactype) {
		this.dose3=dose3;
		this.healthId = healthId;
		this.report=report;
		this.dose1 = dose1;
		this.dose2 = dose2;
		this.vactype = vactype;
	
	//	this.panId = panId;
	
	}
//
//	
//	public PERSON getPerson() {
//		return person;
//	}
//
//	public void setPerson(PERSON person) {
//		this.person = person;
//	}

	public int getHealthId() {
		return healthId;
	}

	public void setHealthId(int healthId) {
		this.healthId = healthId;
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
	public STATUS getReport() {
		return report;
	}

	public void setReport(STATUS report) {
		this.report = report;
	}


}





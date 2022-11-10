package com.Spring.Assignment.Vaccine.Vaccine.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class STATUS {

	@Id
	@Column(name="VACSTATUS")
	private int vacstatus;
	@Column(name="VACREPORT")
	public String vacreport;

public STATUS(){}

public STATUS(int vacstatus, String vacreport) {
	this.vacstatus = vacstatus;
	this.vacreport = vacreport;
}

public int getVacstatus() {
	return vacstatus;
}

public void setVacstatus(int vacstatus) {
	this.vacstatus = vacstatus;
}

public String getVacreport() {
	return vacreport;
}

public void setVacreport(String vacreport) {
	this.vacreport = vacreport;
}

@Override
public String toString() {
	return "STATUS [vacstatus=" + vacstatus + ", vacreport=" + vacreport + "]";
}

}

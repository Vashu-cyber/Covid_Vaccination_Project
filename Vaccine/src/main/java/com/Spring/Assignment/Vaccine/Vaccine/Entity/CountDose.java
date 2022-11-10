package com.Spring.Assignment.Vaccine.Vaccine.Entity;


public class CountDose{
public String vaccinetype;	
public int countDose1;
public int countDose2;
public int countDose3;


public CountDose() {}


public CountDose(String vaccinetype, int countDose1, int countDose2, int countDose3) {
	this.vaccinetype = vaccinetype;
	this.countDose1 = countDose1;
	this.countDose2 = countDose2;
	this.countDose3 = countDose3;
}



public String getVaccinetype() {
	return vaccinetype;
}

public void setVaccinetype(String vaccinetype) {
	this.vaccinetype = vaccinetype;
}
public int getCountDose1() {
	return countDose1;
}

public void setCountDose1(int countDose1) {
	this.countDose1 = countDose1;
}

public int getCountDose2() {
	return countDose2;
}

public void setCountDose2(int countDose2) {
	this.countDose2 = countDose2;
}

public int getCountDose3() {
	return countDose3;
}

public void setCountDose3(int countDose3) {
	this.countDose3 = countDose3;
}



}
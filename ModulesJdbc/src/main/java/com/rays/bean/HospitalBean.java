package com.rays.bean;

public class HospitalBean {
	/*
	 * # Field, Type, Null, Key, Default, Extra
patient_id, int, NO, PRI, , 
name, varchar(45), YES, , , 
age, int, YES, , , 
blood_group, varchar(45), YES, , , 
disease, varchar(25), YES, , , 

	 * */
	private int patientId;
	private String name;
	private int age;
	private String bloodGroup;
	private String disease;
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	
}

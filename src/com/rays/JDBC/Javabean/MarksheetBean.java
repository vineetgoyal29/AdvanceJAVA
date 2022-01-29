package com.rays.JDBC.Javabean;

public class MarksheetBean {
	private int id;
	private int rollNo;
	private String firstName;
	private String lastName;
	private int physics;
	private int chemistry;
	private int mathematics;
	
	public MarksheetBean() {}

	public void setId(int id) {
		this.id = id;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}

	public int getId() {
		return id;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPhysics() {
		return physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public int getMathematics() {
		return mathematics;
	}
	
	
}

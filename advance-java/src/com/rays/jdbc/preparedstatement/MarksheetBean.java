package com.rays.jdbc.preparedstatement;

public class MarksheetBean {
	
	private int Id;
	private String Name;
	private int rollno;
	private int Physics;
	private int Chemistry;
	private int Maths;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getPhysics() {
		return Physics;
	}
	public void setPhysics(int physics) {
		Physics = physics;
	}
	public int getChemistry() {
		return Chemistry;
	}
	public void setChemistry(int chemistry) {
		Chemistry = chemistry;
	}
	public int getMaths() {
		return Maths;
	}
	public void setMaths(int maths) {
		Maths = maths;
	}




	
}

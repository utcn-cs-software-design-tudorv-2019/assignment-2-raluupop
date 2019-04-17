package org.launchcode.studentsmvc.models;

public class Student {
	
	private String firstname;
	private String course;
	
	

	private int idstudent;
	private static int nextID=1;

	public Student(String firstname, String course)
	{
		this();
		this.firstname=firstname;
		this.course=course;
	}

	public Student()
	{
		idstudent=nextID;
		nextID++;
	}
	
	public int getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
}

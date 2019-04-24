package org.launchcode.studentsmvc.models.forms;

import javax.validation.constraints.NotNull;

public class AddEnorllmentItemForm {
	
	@NotNull
	private int enrollmentId;
	
	@NotNull
	private int studentId;
	
	private Iterable<Student> students;
	private Enrollment enrollment;
	public AddEnorllmentItemForm()
	{}
	public AddEnorllmentItemForm(Iterable<Student> students, Enrollment enrollment)
	{
		this.students=students;
		this.enrollment=enrollment;
	}
	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Iterable<Student> getStudents() {
		return students;
	}
	public void setStudents(Iterable<Student> students) {
		this.students = students;
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	

} 

package org.launchcode.studentsmvc.models.forms;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=3, max=15)
	private String firstname;
	
	@NotNull
	@Size(min=1, message="This pnc does not exist!")
	private String pnc;
	
	private StudentType type;
	
	@ManyToOne
	private Course course;

	@ManyToMany(mappedBy="students")
	private List<Enrollment> enrollments;
	
	public Student(String firstname, String pnc)
	{
		
		this.firstname=firstname;
		this.pnc=pnc;
	}

	public Student()
	{
	
	}
	


	
	public int getId() {
		return id;
	}

	/*public void setId(int id) {
		this.id = id;
	}*/

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPnc() {
		return pnc;
	}

	public void setPnc(String pnc) {
		this.pnc = pnc;
	}

	public StudentType getType() {
		return type;
	}

	public void setType(StudentType type) {
		this.type = type;
	}

	public void setCourse(Course cou) {
		this.course=cou;
		
	}
	
	
	
}

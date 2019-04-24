package org.launchcode.studentsmvc.models.forms;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=3, max=15)
	private String name;
	
	@ManyToMany
	private List<Student> students;
	
	public Enrollment() {}
	
	public void addEnroll(Student enroll)
	{students.add(enroll);}
	
	public int getId() {return id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name=name;}
	
	public List<Student> getStudents() {return students;}
}

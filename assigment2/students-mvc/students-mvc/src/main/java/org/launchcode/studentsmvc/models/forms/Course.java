package org.launchcode.studentsmvc.models.forms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Course {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=3, max=15)
	private String name;
	
	@OneToMany
	@JoinColumn(name="course_idcourse")
	private List<Student> students= new ArrayList<>();
	
	
    public Course() {}
    public Course(String name)
    {
    	this.name=name;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    public List<Student> getStudents() {
    	return students;
    }
}

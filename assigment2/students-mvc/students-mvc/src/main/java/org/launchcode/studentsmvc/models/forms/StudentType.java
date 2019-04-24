package org.launchcode.studentsmvc.models.forms;

public enum StudentType {

	Trecut("Trecut"),
	Picat("Picat");
	
	private final String firstname;
	
	StudentType(String firstname)
	{
		this.firstname=firstname;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
}

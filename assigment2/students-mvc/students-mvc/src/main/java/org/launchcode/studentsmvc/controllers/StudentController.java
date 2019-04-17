package org.launchcode.studentsmvc.controllers;

import java.util.ArrayList;

import org.launchcode.studentsmvc.models.Student;
import org.launchcode.studentsmvc.models.StudentData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student")
public class StudentController {

	//Request path: /student
	@RequestMapping("/")
	public String index(Model model)
	{
	
		
		
		model.addAttribute("students", StudentData.getAll());
		model.addAttribute("title", "Students");
		return "student/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String displayAddStudentForm(Model model)
	{
		model.addAttribute("title", "Add Student");
		return "student/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String processAddStudentForm(@RequestParam String firstname, @RequestParam String course)
	{
		//redirect to /student
		Student newStudent=new Student(firstname,course);
		StudentData.add(newStudent);
		return "redirect:";
	}
	
	@RequestMapping(value="remove",method=RequestMethod.GET)
	public String displayRemoveStudentForm(Model model)
	{
		model.addAttribute("students", StudentData.getAll());
		model.addAttribute("title", "Remove Student");
		return "student/remove";
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String processRemoveStudentForm(@RequestParam int[] idstudents)
	{
		for(int idstudent: idstudents)
		{
			StudentData.remove(idstudent);
			
		}
		return "redirect:";
	}
	
}

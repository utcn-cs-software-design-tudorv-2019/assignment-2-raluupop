package org.launchcode.studentsmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.launchcode.studentsmvc.models.data.CourseDao;
import org.launchcode.studentsmvc.models.data.StudentDao;
import org.launchcode.studentsmvc.models.forms.Course;
import org.launchcode.studentsmvc.models.forms.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	CourseDao courseDao;

	//Request path: /student
	@RequestMapping("/")
	public String index(Model model)
	{
	
		
		
		model.addAttribute("students", studentDao.findAll() );
		model.addAttribute("title", "Students");
		return "student/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String displayAddStudentForm(Model model)
	{
		model.addAttribute("title", "Add Student");
		model.addAttribute( new Student());
		model.addAttribute("courses", courseDao.findAll());
		return "student/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String processAddStudentForm(@ModelAttribute @Valid Student newStudent, Errors errors,@RequestParam int courseid, Model model)
	{
		//redirect to /student
		if(errors.hasErrors())
		{
			model.addAttribute("title", "Add Student");
			model.addAttribute("courses", courseDao.findAll());
			return "student/add";
		}
		Course cou=courseDao.findOne(courseid);
		newStudent.setCourse(cou);
		studentDao.save(newStudent);
		return "redirect:";
	}
	
	@RequestMapping(value="remove",method=RequestMethod.GET)
	public String displayRemoveStudentForm(Model model)
	{
		model.addAttribute("students", studentDao.findAll());
		model.addAttribute("title", "Remove Student");
		return "student/remove";
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String processRemoveStudentForm(@RequestParam int[] idstudents)
	{
		for(int idstudent: idstudents)
		{
		studentDao.delete(idstudent);
			
		}
		return "redirect:";
	}
	
	@RequestMapping(value="course", method = RequestMethod.GET)
	public String course(Model model, @RequestParam int id)
	{
		Course cou=courseDao.findOne(id);
		List<Student> students = cou.getStudents();
		model.addAttribute("students", students);
		model.addAttribute("title", "Students in the Course" + cou.getName());
		return "student/index";
	}
	
}

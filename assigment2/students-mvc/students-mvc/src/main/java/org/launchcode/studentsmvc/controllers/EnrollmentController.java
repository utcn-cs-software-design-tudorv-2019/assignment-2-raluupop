package org.launchcode.studentsmvc.controllers;

import javax.validation.Valid;

import org.launchcode.studentsmvc.models.data.EnrollmentDao;
import org.launchcode.studentsmvc.models.data.StudentDao;
import org.launchcode.studentsmvc.models.forms.AddEnorllmentItemForm;
import org.launchcode.studentsmvc.models.forms.Enrollment;
import org.launchcode.studentsmvc.models.forms.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="enrollment")
public class EnrollmentController {
	
	@Autowired
	EnrollmentDao enrollmentDao;
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("title", "Enrollments");
		model.addAttribute("enrollments", enrollmentDao.findAll());
		return "enorllment/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String displayAddStudentForm(Model model)
	{
		model.addAttribute("title", "Add Enrollment");
		model.addAttribute( new Enrollment());
		
		return "enrollment/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String processAddStudentForm(@ModelAttribute @Valid Enrollment enrollment, Errors errors,@RequestParam int courseid, Model model)
	{
		//redirect to /student
		if(errors.hasErrors())
		{
			model.addAttribute("title", "Add Enrollment");
		
			return "enrollment/add";
		}
		
	
		
		enrollmentDao.save(enrollment);
		return "redirect: view/" + enrollment.getId();
	}
	
	@RequestMapping(value="view/{enorllmentId}", method=RequestMethod.GET)
	public String viewEnorllment(Model model,@PathVariable int enrollmentId)
	{
		Enrollment enrollment=enrollmentDao.findOne(enrollmentId);
		model.addAttribute("title", enrollment.getName());
		model.addAttribute("students", enrollment.getStudents());
		model.addAttribute("enrollmentId", enrollment.getId());
	
		return "enrollment/view"; 
			
	}
	
	@RequestMapping(value="add-item/{enorllmentId}", method=RequestMethod.GET)
	public String addItem(Model model, @PathVariable int enorllmentId)
	{
		Enrollment enrollment= enrollmentDao.findOne(enorllmentId);
		AddEnorllmentItemForm form= new AddEnorllmentItemForm(
				studentDao.findAll(),enrollment);
	
		model.addAttribute("title", "Add new enorllment item: " + enrollment.getName());
		model.addAttribute("form",form);
		
		return "enrollment/add-item";
	}
	@RequestMapping(value="add-item", method=RequestMethod.POST)
	public String addItem(Model model, @ModelAttribute @Valid AddEnorllmentItemForm form,Errors errors)
	{
		if(errors.hasErrors())
		{
			model.addAttribute("form", form);
			
			return "enrollment/add-item";
		}
		
		Student theStudent=studentDao.findOne(form.getStudentId());
		Enrollment theEnrollment=enrollmentDao.findOne(form.getEnrollmentId());
		theEnrollment.addItem(theStudent);
		enrollmentDao.save(theEnrollment);
		
		return "redirect:/enrollment/view" + theEnrollment.getId();
	}
	
}

package org.launchcode.studentsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	
	@RequestMapping(value=" ")
	@ResponseBody
	public String index()
	{
		return "Student managing system";
	}
	
}

/**
 * 
 */
package com.iqbal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iqbal.entity.Student;
import com.iqbal.service.StudentService;


/**
 * @author TCS
 *
 */
@RestController
public class HomeController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewPage() {
		System.out.println("enter.................");

		return new ModelAndView("index.html");
	}


	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {

		return new ModelAndView("student");
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Validated Student student, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Student userExists = studentService.findUserByEmail(student.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("student");
		} else {
			studentService.saveStudent(student);
			modelAndView.addObject("successMessage", "Student has been registered successfully");
			modelAndView.addObject("student", new Student());
			modelAndView.setViewName("student");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public List<Student> getStudentList() {
		
		List<Student> student = studentService.getStudentList();
		return student;
		
	}

}

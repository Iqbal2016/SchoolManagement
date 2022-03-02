/**
 * 
 */
package com.iqbal.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	/*****************************************
	 *  Landing Page
	 ******************************************/

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewPage() {
		System.out.println("enter.................");

		return new ModelAndView("index.html");
	}

	/*****************************************
	 *  Create Student Page
	 ******************************************/

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student(Map<String, Object> model) {
		List<Student> student = studentService.getStudentList();
		model.put("student", student);
		return new ModelAndView("student");
	}
	
	/*****************************************
	 *  Store Student
	 ******************************************/
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Student student, BindingResult bindingResult, Model model) {
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
		
		//return modelAndView;
		return new ModelAndView("redirect:/studentList");
	}
	
	/*****************************************
	 *  Get Students List
	 ******************************************/
	
	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public ModelAndView getStudentList(Map<String, Object> model ) {
		ModelAndView modelAndView = new ModelAndView();
		List<Student> student = studentService.getStudentList();
		for (Iterator iterator = student.iterator(); iterator.hasNext();) {
			 System.out.println(iterator.next());
			
		}
	
		modelAndView.addObject("student", student);
		modelAndView.setViewName("viewStudent");
		//return new ModelAndView("redirect:/studentList");
		return modelAndView;
		
	}

}

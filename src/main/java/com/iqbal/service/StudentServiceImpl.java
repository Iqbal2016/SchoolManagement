/**
 * 
 */
package com.iqbal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.bean.Utility;
import com.iqbal.entity.Student;
import com.iqbal.repository.StudentRepository;

/**
 * @author TCS
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	/*****************************************
	 *  Store employee
	 ******************************************/
	@Override
	public void saveStudent(Student student) {
		student.setCreatedDate(Utility.getCurrentTimeStamp());
		student.setModifiedDate(Utility.getCurrentTimeStamp());
		studentRepository.save(student);
		
	}

	@Override
	public Student findUserByEmail(String email) {
		 return studentRepository.findUserByEmail(email);
	}
	
	/*****************************************
	 *  Get Students List
	 ******************************************/
	
	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

}

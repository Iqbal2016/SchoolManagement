package com.iqbal.service;

import java.util.List;

import com.iqbal.entity.Student;

public interface StudentService {

	void saveStudent(Student student);

	Student findUserByEmail(String email);

	List<Student> getStudentList();



}

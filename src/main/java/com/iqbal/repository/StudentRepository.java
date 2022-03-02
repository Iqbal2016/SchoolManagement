package com.iqbal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.entity.Student;

@Repository("userRepository")
public interface  StudentRepository extends JpaRepository<Student, Long>{

	Student findUserByEmail(String email);

	

}

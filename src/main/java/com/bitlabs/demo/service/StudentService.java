package com.bitlabs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitlabs.demo.model.Student;
import com.bitlabs.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public String addStudent(Student student) {  
		Student student1=studentRepo.save(student);
		if(student1 != null) {
		  return "registeration was successful";
		}
		return "something went wrong";
		
	}

	public String deleteStudentById(Integer id) {
		studentRepo.deleteById(id);
		return "deleted successfully";
	}
	
}

package com.bitlabs.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bitlabs.demo.model.Book;
import com.bitlabs.demo.model.Student;
import com.bitlabs.demo.service.StudentService;

@RestController
@RequestMapping("/studentService")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addStudent")
	public String registerStudent(@RequestBody Student student) {
		
		String email=student.getStudentEmail();
		String response=restTemplate.getForObject("http://emailservice/emailService/sendOtp/"+email, String.class );
		System.out.println(response);
		String result=studentservice.addStudent(student);		
		return result;
		
	}
	@GetMapping("/getAllBook")
	public List<Book> getAllBook(){
		Book[] books=restTemplate.getForObject("http://bookservice/bookService/getAll",Book[].class);
		List al=Arrays.asList(books);
		return al;
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	   public String deleteStudentById(@PathVariable Integer id ) {
		   String result=studentservice.deleteStudentById(id);
		return result;   
	   }
	
}

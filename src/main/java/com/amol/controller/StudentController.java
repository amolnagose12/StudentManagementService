package com.amol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.exception.StudentNotFoundException;
import com.amol.model.Student;
import com.amol.service.IStudentManagementService;

@RestController
@RequestMapping("/student/api")
public class StudentController {
	
	@Autowired
	private IStudentManagementService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollStudent(@RequestBody Student student){
		System.out.println("Hello");
		String resultMsg = service.registerStudent(student);
		return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> fetchAllStudent(){
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	} 
	
	@GetMapping("/fetchstudentbyId/{id}")
	public ResponseEntity<?> fetchStudentById(@PathVariable("id") Integer id){
		Student msg;
		try {
			msg = service.getStudentById(id);
			return new ResponseEntity<Student>(msg,HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity<String>("No data with id " + id,HttpStatus.OK);
		}		
	}
	
	@PutMapping("/updatedetails")
	public ResponseEntity<String> updateStudentDetails(@RequestBody Student student){
		try {
			String result = service.updateStudent(student);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity<String>("No data with id " + student.getId(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable("id") Integer id){
		String endMsg;
		try {
			endMsg = service.deleteStudentById(id);
			return new ResponseEntity<String>(endMsg,HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity<String>("No student with id "+ id,HttpStatus.OK);
		}
		
	}
	

}

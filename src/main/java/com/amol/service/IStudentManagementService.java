package com.amol.service;

import java.util.List;

import com.amol.exception.StudentNotFoundException;
import com.amol.model.Student;

public interface IStudentManagementService {
	public String registerStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer id) throws StudentNotFoundException;
	public String updateStudent(Student student) throws StudentNotFoundException;
	public String deleteStudentById(Integer id) throws StudentNotFoundException;
}

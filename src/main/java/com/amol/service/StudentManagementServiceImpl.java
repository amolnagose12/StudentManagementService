package com.amol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.dao.IStudentRepo;
import com.amol.exception.StudentNotFoundException;
import com.amol.model.Student;

@Service
public class StudentManagementServiceImpl implements IStudentManagementService {
	
	@Autowired
	private IStudentRepo repo;

	@Override
	public String registerStudent(Student student) {
		Integer sid = repo.save(student).getId();
		return "Student registered with ::" + sid;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> listOfStudents = repo.findAll();
		return listOfStudents;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException   {
		java.util.Optional<Student> optional= repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new StudentNotFoundException("Student not found with id " + id);
		}
		
//		return repo.findById(id)
//				.orElseThrow(()-> new StudentNotFoundException("Student not found with id " + id));
		
	}

	@Override
	public String updateStudent(Student student) throws StudentNotFoundException {
		java.util.Optional<Student> optional= repo.findById(student.getId());
		if(optional.isPresent()) {
			repo.save(student);
			return "student details updated with " + student.getId();
		}else {
			throw new StudentNotFoundException("Students with id " + student.getId() + "Not found");
		}		
	}

	@Override
	public String deleteStudentById(Integer id) throws StudentNotFoundException {
		java.util.Optional<Student> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return "Student with id :: " + id + "deleted";
		}else {
			throw new StudentNotFoundException("Student Not found with ");
		}
		}

}

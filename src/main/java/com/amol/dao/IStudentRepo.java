package com.amol.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}

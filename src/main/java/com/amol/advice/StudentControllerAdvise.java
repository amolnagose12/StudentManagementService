package com.amol.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amol.error.ErrorDetails;
import com.amol.exception.StudentNotFoundException;

@RestControllerAdvice
public class StudentControllerAdvise {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleStudentNotFound(StudentNotFoundException sf){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),sf.getMessage(),
				"404-NOTFOUND");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),
				"404-NOTFOUND");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);		
	}
}

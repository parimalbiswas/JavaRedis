package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.parimal.entity.StudentEntity;
import com.parimal.service.StudentService;

@RestController
public class StudentController
{
	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<StudentEntity> createStudentAPI(@RequestBody StudentEntity studentEntity)
	{
		return new ResponseEntity<StudentEntity>(studentService.createStudent(studentEntity), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StudentEntity> deleteStudentAPI(@PathVariable("id") Long id)
	{
		return new ResponseEntity<StudentEntity>(studentService.deleteStudent(id), HttpStatus.OK);
	}

	@PostMapping("/all")
	public ResponseEntity<List<StudentEntity>> viewAllStudentAPI(@RequestBody StudentEntity studentEntity)
	{
		return new ResponseEntity<>(studentService.viewAllStudent(), HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<StudentEntity> updateStudentAPI(@PathVariable("id") Long id,
			@RequestBody StudentEntity studentEntity)
	{
		return new ResponseEntity<StudentEntity>(studentService.updateStudent(id, studentEntity), HttpStatus.ACCEPTED);
	}

	@PostMapping("/upload")
	public ResponseEntity<List<StudentEntity>> uploadThroughCSVAPI(@RequestBody MultipartFile file)
	{
		return new ResponseEntity<>(studentService.uploadThroughCSV(file), HttpStatus.ACCEPTED);
	}

}

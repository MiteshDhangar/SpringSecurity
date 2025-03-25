package com.mitesh.SpringSecurity.Controller;

import java.util.ArrayList;
import java.util.List;

import com.mitesh.SpringSecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	List<Student> students=new ArrayList<>(List.of(
			new Student(1,"Mitesh","Java"),
			new Student(2,"Sachin","MERN Stack")
			));
	
	@GetMapping("students")
	public List<Student> getStudents(){

		return students;
	}

	@PostMapping("students")
	public void addStudent(@RequestBody Student student) {

		students.add(student);
	}
}
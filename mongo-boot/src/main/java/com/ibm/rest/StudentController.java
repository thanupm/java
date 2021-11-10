package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.model.student;
import com.ibm.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping(value="/student" , consumes="application/json")
	public String addFlight(@RequestBody student s) {
		service.save(s);
		return "Student added";
	}
	
	@GetMapping(value="/students", produces ="application/json")
	public List<student> getAll(){
		return service.fetchAll();
	}
	
	@GetMapping(value = "/students/{rolNo}",produces="application/json")
	public student getByRolNo(@PathVariable int rolNo) {
		return service.fetch(rolNo);
	}
}

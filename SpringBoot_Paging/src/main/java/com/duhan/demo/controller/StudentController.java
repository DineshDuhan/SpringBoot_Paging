package com.duhan.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duhan.demo.dao.StudentRepo;
import com.duhan.demo.interfaces.Stud_Service_Interface;
import com.duhan.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo Stud_repo;
	
	@Autowired
	Stud_Service_Interface serviceInterface;	
	
	@RequestMapping("/")
	public String doSomething() {
		return "home.jsp";
	}
	
    @PostMapping("/student")
	public Map<String, Object> addStudent(@RequestBody Student s) {  
    	return serviceInterface.updateProduct(s);
	}
     
    @GetMapping("/students/getPage/{pageNumber}/{totalPage}")
	public Page<Student> getStudentPage(@PathVariable int pageNumber,@PathVariable int totalPage) {  
    	return serviceInterface.getStudentPage(pageNumber,totalPage);	
	}
    
    @GetMapping("/students/ByNameLen/{pageNumber}/{totalPage}")
 	public Page<Student> getStudentByLength(@PathVariable int pageNumber,@PathVariable int totalPage) {  
     	return serviceInterface.getStudByLength(pageNumber,totalPage);	
 	}
    
    @DeleteMapping("/student/{aid}")
    public String deleteAlien(@PathVariable int aid) {
    	return serviceInterface.deleteProduct(aid);
    } 
    
    @RequestMapping("/students")
    public List<Student> getAliens() {
           return Stud_repo.findAll(); 
    }
    
    @RequestMapping("/student/{sid}")
	public java.util.Optional<Student> getAlien(@PathVariable("sid") int sid) {
		return Stud_repo.findById(sid);
	}   
}

	


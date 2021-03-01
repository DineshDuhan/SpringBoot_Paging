package com.duhan.demo.interfaces;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.duhan.demo.model.Student;

public interface Stud_Service_Interface {
	  
	   public abstract Map<String, Object> updateProduct(Student s);
	   public abstract String deleteProduct(int sid);
	   public abstract Collection<Student> getProducts();
       public abstract Page<Student> getStudentPage(int pageNumber, int totalPage);
       public abstract Page<Student> getStudByLength(int pageNumber, int totalPage);
}

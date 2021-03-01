package com.duhan.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.duhan.demo.model.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query(value = "SELECT * FROM Student s WHERE LENGTH(s.sname) > 9 ",nativeQuery = true)
	Page<Student> getStudentByLength();
}

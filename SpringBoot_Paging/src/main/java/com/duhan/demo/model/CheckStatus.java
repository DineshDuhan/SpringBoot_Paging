package com.duhan.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.duhan.demo.dao.StudentRepo;

public class CheckStatus {
  public CheckStatus() {
	  
  }
  public boolean check(Student s) {
	  
	  String response = s.getIsMarried();
	  if(response.equals("Yes")) {
		  return true;
	  }
	  else {
	   return false;

	  }
	  }
  @Autowired
  private StudentRepo repo;

  public long count() {
      return repo.count();
  }
}

package com.duhan.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Student_Response {

	public Map<String, Object> CheckFlag() {
		
    	Map<String,Object> out = new HashMap<String,Object>();
       
  
     	out.put("Status","Failure");
     	out.put("Message", "Permission Denied");
		
		return out;
	}
	  
	public Map<String, Object> getResponse(Student s) {
		
    	Map<String,Object> out = new HashMap<String,Object>();
       
  
   	out.put("Status","Success");
   	out.put("Data", s);
   	out.put("Message", "Data Updated");
		
		return out;
	}

	public boolean checkInput(Student s){
		 System.out.println("im here");
		 String str = s.getSname();
		if(str.equals("")) {
			 System.out.println("im skjhv here");
			return false;
		}
		else {
		  
			return true;
		}
	}
	
	public Map<String, Object> Return_WrongInput(Student s) {
		
    	Map<String,Object> out =new HashMap<String,Object>();
       
  
     	out.put("Status","Failed");
     	out.put("Data", s);
     	out.put("Message", "Name Can Not be NUll");
		
		return out;
	}
	
}

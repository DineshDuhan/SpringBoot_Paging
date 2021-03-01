package com.duhan.demo.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.duhan.demo.dao.StudentRepo;
import com.duhan.demo.interfaces.Stud_Service_Interface;
import com.duhan.demo.model.CheckStatus;
import com.duhan.demo.model.Student;
import com.duhan.demo.model.Student_Response;


@Service
@PropertySource("classpath:info.properties")
public class Stud_Service_Implement implements Stud_Service_Interface{

	@Autowired
	StudentRepo Stud_repo;
	

	@Override
	public Page<Student> getStudByLength(int pageNumber, int totalPage) {
		return Stud_repo.getStudentByLength();	
	}

	@Override
	public Page<Student> getStudentPage(int pageNumber, int totalPage) {
		
	   return Stud_repo.findAll(PageRequest.of(pageNumber,totalPage));
		
	}

	@Value("${flag}")
	private int flag;
	
	private int count;
	
	@Override
	public Map<String, Object> updateProduct(Student s) {
		
	    //  System.out.println(flag);
		
	 	Student_Response res = new Student_Response();
    	Map<String,Object> out =new HashMap<String,Object>();
    	
    	//check if name is null or not
    	if(flag == 0) {
    		return res.CheckFlag();
    	}
  	    boolean check = res.checkInput(s);
    	  if(!check) {		
    		  out =  res.Return_WrongInput(s);
    		  return out;	 
    	  }
    	  
     //Married status will be checked here	  
    	CheckStatus c = new CheckStatus();
    	count = (int)Stud_repo.count();
    	count++;
    	s.setSid(count);
    	boolean b = c.check(s);
    	
    	//if isMarried is "Yes"
    	if(b) {
    		Stud_repo.save(s);
   	    }
    	
    	// if isMarried is "No" then make wife's info null
    	else {
    		s.setWife_name("");
    		s.setWife_age("");
    		Stud_repo.save(s);
    	}
        out  = res.getResponse(s);
		return out;
	}

	@Override
	public String deleteProduct(int sid) {
		Student s = Stud_repo.getOne(sid);
    	Stud_repo.delete(s);
    	return "deleted";
		
	}

	@Override
	public Collection<Student> getProducts() {
		
		return null;
	}

}

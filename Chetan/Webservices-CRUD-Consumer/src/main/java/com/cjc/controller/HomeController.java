package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.model.Student;
@CrossOrigin("*")
@RestController
public class HomeController 
{

	@Autowired
	RestTemplate rTemp;
	
	@RequestMapping("/log/{username}/{password}")
	public List prelogin(@PathVariable ("username") String username,@PathVariable ("password") String password)
	{
		System.out.println(username);
		String url="http://localhost:8081/log/"+username+"/"+password;
		List l=rTemp.getForObject(url, List.class);
		return l;
	}
	@RequestMapping(value="/reg",consumes= "application/json",method = RequestMethod.POST)
	public Student register(@RequestBody Student s)
	{
		String url="http://localhost:8081/reg";
		Student s1= rTemp.postForObject(url, s, Student.class);
		return s1;
		
	}
	
	  @RequestMapping(value="/delete/{rollno}")
	  public void delete(@PathVariable("rollno") Integer rollno)
	  { 
		 // server.port=8082
		 String url="http://localhost:8081/delete/"+rollno; 
	  
	     rTemp.delete(url);
	
	  }
	  
	  @RequestMapping(value="/edit",consumes= "application/json",method = RequestMethod.POST) 
	  public void edit(@RequestBody Student s)
 
	  { 
		  System.out.println("hhh");
		  String url="http://localhost:8081/edit"; 
		  rTemp.put(url, s);
		  
		
	  	
	  
	  }
	 
	
}

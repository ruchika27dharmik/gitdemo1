package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Student;
import com.cjc.serviceint.HserviceInt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")
@RestController
public class HomeController 
{
	
	@Autowired
	private HserviceInt hs;
	
	
	@RequestMapping(value = "/log/{username}/{password}", produces = "application/json",method = RequestMethod.GET)
	public String logincheck(@PathVariable("username") String username, @PathVariable("password") String password,
			Model m) throws JsonProcessingException 
	{
		System.out.println(username);
			if (username.equals("admin") && password.equals("admin")) 
			{
				List<Student> l = hs.getAll();
				
				ObjectMapper ob=new ObjectMapper();
				String json=ob.writeValueAsString(l);
				return json;
			}
			else 
			{
				System.out.println(username);
				List<Student> l = hs.loginStudent(username, password);
				System.out.println(l);
				if (!l.isEmpty())
				{
					List<Student> l1 = hs.loginStudent(username, password);
					ObjectMapper ob=new ObjectMapper();
					String json=ob.writeValueAsString(l1);
					return json;
				}
				else
				{
					m.addAttribute("wng", "PLZ ENTER VALID USERNAME AND PASSWORD");
					return "Index";
				}

			}

		}


	@RequestMapping(value="/reg",produces = "application/json",method = RequestMethod.POST)
	public Student dataSave(@RequestBody Student s)
	{
			Student s1=hs.saveData(s);
				return s1;
	}
	
	public String getAllData() throws JsonProcessingException
	{
		List<Student> l=hs.getAll();
		ObjectMapper ob=new ObjectMapper();
		String json=ob.writeValueAsString(l);
		return json;
	}
	
	@RequestMapping(value = "/delete")
	public String deleteData(@PathVariable("rollno") Integer rollno) throws JsonProcessingException
	{
		//server.port=8081
		hs.delete(rollno);
		List<Student> l=hs.getAll();
		ObjectMapper ob=new ObjectMapper();
		String json=ob.writeValueAsString(l);
		return json;
	}
	
	
	@RequestMapping(value="/edit",produces = "application/json",method = RequestMethod.PUT)
	public Student updateData(@RequestBody Student s) throws JsonProcessingException 
	{
		System.out.println("jjj");
		 Student s1=hs.updateData(s);
		return s1;
		

	}

	/*
	 * @RequestMapping(value = "/edit") public String editData(@RequestBody Student
	 * s) throws JsonProcessingException {
	 * 
	 * hs.editData(s); List<Student> l = hs.getAll(); ObjectMapper ob=new
	 * ObjectMapper(); String json=ob.writeValueAsString(l); return json;
	 * 
	 * }
	 */
	

}

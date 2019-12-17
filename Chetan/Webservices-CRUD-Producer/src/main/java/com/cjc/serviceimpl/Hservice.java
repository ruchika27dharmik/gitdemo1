package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Student;
import com.cjc.repository.HomeRepository;
import com.cjc.serviceint.HserviceInt;

@Service
public class Hservice implements HserviceInt {

	@Autowired
	HomeRepository hr;

	public Student saveData(Student s) 
	{
		return hr.save(s);
	}

	public List<Student> getAll() 
	{
		return (List<Student>) hr.findAll();
	}

	public List<Student> loginStudent(String username, String password) 
	{

		return hr.findAllByUsernameAndPassword(username, password);
	}

	public void delete(int rollno) 
	{
		hr.deleteById(rollno);
	}

	public Student updateData(Student s) 
	{
		return hr.save(s);
	}



}

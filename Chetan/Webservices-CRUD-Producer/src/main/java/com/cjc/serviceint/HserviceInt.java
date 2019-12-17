package com.cjc.serviceint;

import java.util.List;

import com.cjc.model.Student;

public interface HserviceInt 
{
	public Student saveData(Student s) ;
	public List<Student> getAll();
	public void delete(int rollno);
	public List<Student> loginStudent(String username, String password);
	public Student updateData(Student s);
	
}

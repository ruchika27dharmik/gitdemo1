package com.cjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cjc.model.Student;

public interface HomeRepository extends CrudRepository<Student, Integer>
{
	
	  public List<Student>findAllByUsernameAndPassword(String username,String password);
	  
	  @Query("from Student where rollno=:rollno")
	 public Student updateData(int rollno);
	
}

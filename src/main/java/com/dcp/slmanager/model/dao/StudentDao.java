package com.dcp.slmanager.model.dao;

import java.util.List;

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentGroup;

public interface StudentDao {
	
	List<Student> getStudents();
	
	Student getStudent(Integer id);
	
	Student saveStudent(Student student);
	
	StudentGroup getGroup(Integer id);
	
	StudentGroup saveGroup(StudentGroup group);

}
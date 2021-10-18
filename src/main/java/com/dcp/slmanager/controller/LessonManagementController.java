package com.dcp.slmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentDto;
import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.StudentGroupDto;
import com.dcp.slmanager.model.dao.StudentDao;
import com.dcp.slmanager.model.dao.StudentGroupDao;

@RestController
public class LessonManagementController {
	
	private static Logger logger = LoggerFactory.getLogger(LessonManagementController.class);
	
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentGroupDao studentGroupDao;
	
	public LessonManagementController() {
		logger.trace("Hi from Controller");
	}
	
	
	@GetMapping("/students")
	public List<StudentDto> list() {
		List<Student> students = studentDao.getStudents();
		List<StudentDto> dto = new ArrayList<StudentDto>();
		
		for (Student student : students) {
			dto.add(new StudentDto(student) );
		}
		return dto;
	}
	
	
	@GetMapping("/student/{id}")
	public StudentDto getStudent( @PathVariable Integer id) {
		Student student = studentDao.getStudent(id);
		
		return new StudentDto(student);
	}
	
	
	@GetMapping("/groups")
	public List<StudentGroupDto> groupList() {
		List<StudentGroup> studentGroups = studentGroupDao.getGroups();
		List<StudentGroupDto> groupDto = new ArrayList<StudentGroupDto>();
		
		for (StudentGroup studentGroup : studentGroups) {
			groupDto.add(new StudentGroupDto(studentGroup) );
		}
		return groupDto;
	}

}

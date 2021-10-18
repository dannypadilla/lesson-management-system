package com.dcp.slmanager.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.StudentGroupDto;
import com.dcp.slmanager.model.dao.StudentGroupDao;


@RestController
@RequestMapping("/groups")
public class StudentGroupController {
	
	private static Logger logger = LoggerFactory.getLogger(StudentGroupController.class);
	
	
	
	@Autowired
	private StudentGroupDao studentGroupDao;
	
	public StudentGroupController() {
		logger.trace("Hi from StudentGroup Controller");
	}
	
	
	
	
	
	@GetMapping
	public List<StudentGroupDto> list() {
		List<StudentGroup> studentGroups = studentGroupDao.getGroups();
		List<StudentGroupDto> groupDto = new ArrayList<StudentGroupDto>();
		
		for (StudentGroup studentGroup : studentGroups) {
			groupDto.add(new StudentGroupDto(studentGroup) );
		}
		return groupDto;
	}
	
	
	@GetMapping("{id}")
	public StudentGroupDto getGroup( @PathVariable Integer id) {
		StudentGroup studentGroup = studentGroupDao.getStudentGroup(id);
		
		return new StudentGroupDto(studentGroup);
	}

}
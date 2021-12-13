package com.dcp.slmanager.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.StudentGroupDto;
import com.dcp.slmanager.model.dao.StudentGroupDao;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	
	@GetMapping("/{id}")
	public StudentGroupDto get( @PathVariable Integer id) {
		StudentGroup studentGroup = studentGroupDao.getStudentGroup(id);
		
		return new StudentGroupDto(studentGroup);
	}
	
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentGroupDto add( @RequestBody StudentGroupDto studentGroupDto ) {
		
        if ( !StringUtils.hasText( studentGroupDto.getName() ) ) {
        	throw new ResponseStatusException(
        			HttpStatus.BAD_REQUEST, "Group name is required");
        }
        
        List<StudentGroup> studentGroupList = studentGroupDao.getGroups();
        for (StudentGroup tmpStudentGroup: studentGroupList) {
        	if (tmpStudentGroup.getName().equalsIgnoreCase(studentGroupDto.getName() ) ) {
        		throw new ResponseStatusException(
        				HttpStatus.BAD_REQUEST, "Group already exists");
        	}
        }
        
        StudentGroup studentGroup = new StudentGroup();
        
        studentGroup.setName( studentGroupDto.getName() );
        
        studentGroup = studentGroupDao.saveStudentGroup(studentGroup);
        return new StudentGroupDto(studentGroup);
	}

}
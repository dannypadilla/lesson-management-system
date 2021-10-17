package com.dcp.slmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentDto;
import com.dcp.slmanager.model.dao.StudentDao;

@RestController
public class LessonManagementController {
	
	private static Logger logger = LoggerFactory.getLogger(LessonManagementController.class);
	
	
	@Autowired
	private StudentDao studentDao;
	
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

}

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

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentDto;
import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.dao.StudentDao;
import com.dcp.slmanager.model.dao.StudentGroupDao;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
	
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentGroupDao studentGroupDao;
	
	public StudentController() {
		logger.trace("Hi from Student Controller");
	}
	
	
	@GetMapping
	public List<StudentDto> list() {
		List<Student> students = studentDao.getStudents();
		List<StudentDto> dto = new ArrayList<StudentDto>();
		
		for (Student student : students) {
			dto.add(new StudentDto(student) );
		}
		return dto;
	}
	
	
	@GetMapping("/{id}")
	public StudentDto get( @PathVariable Integer id) {
		Student student = studentDao.getStudent(id);
		
		return new StudentDto(student);
	}
	
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto add( @RequestBody StudentDto studentDto ) {
        if ( !StringUtils.hasText( studentDto.getName() ) ) {
        	throw new ResponseStatusException(
        			HttpStatus.BAD_REQUEST, "Student name is required");
        }
        if ( !StringUtils.hasText( studentDto.getBirthYear().toString() ) ) {
        	throw new ResponseStatusException(
        			HttpStatus.BAD_REQUEST, "Birth year is required");
        }
        if ( !StringUtils.hasText( studentDto.getParentName() ) ) {
        	throw new ResponseStatusException(
        			HttpStatus.BAD_REQUEST, "Parent name is required");
        }
        if ( !StringUtils.hasText( studentDto.getParentEmail() ) ) {
        	throw new ResponseStatusException(
        			HttpStatus.BAD_REQUEST, "Parent's Email is required");
        }
        
        Student student = new Student();
        
        student.setName( studentDto.getName() );
        student.setBirthYear(studentDto.getBirthYear() );
        student.setParentName(studentDto.getParentName() );
        student.setParentEmail(studentDto.getParentEmail() );
        
        if (studentDto.getGroupId() != null) {
        	StudentGroup studentGroup = studentGroupDao
        			.getStudentGroup( studentDto.getGroupId() );
        	student.setStudentGroup( studentGroup );
        }
        
        student = studentDao.saveStudent( student );
        return new StudentDto(student);
    }	
	
}
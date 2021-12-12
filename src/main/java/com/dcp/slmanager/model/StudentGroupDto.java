package com.dcp.slmanager.model;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentGroupDto {
	
	private static Logger logger = LoggerFactory.getLogger(StudentGroupDto.class);
	
	private Integer studentGroupId;
	private String groupName;
	private List<String> studentList;
	
	public StudentGroupDto() {}
	
	public StudentGroupDto(StudentGroup studentGroup) {
		logger.trace("Called StudentGroupDto Constructor");
		studentList = new ArrayList<String>();
		
		this.studentGroupId = studentGroup.getStudentGroupId();
		this.groupName = studentGroup.getName();
		
		if (studentGroup.getStudentList() != null) {
			for (Student s : studentGroup.getStudentList() ) {
				this.studentList.add(s.getName() );
			}

		}

	}
	
	public Integer getStudentGroupId() {
		return studentGroupId;
	}

	public void setStudentGroupId(Integer studentGroupId) {
		this.studentGroupId = studentGroupId;
	}

	public String getName() {
		return groupName;
	}

	public void setName(String groupName) {
		this.groupName = groupName;
	}
	
	public List<String> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(List<String> studentList) {
		this.studentList = studentList;
	}

}

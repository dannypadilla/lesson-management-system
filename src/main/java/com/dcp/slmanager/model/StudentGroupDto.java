package com.dcp.slmanager.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentGroupDto {
	
	private static Logger logger = LoggerFactory.getLogger(StudentGroupDto.class);
	
	private Integer studentGroupId;
	private String groupName;
	
	public StudentGroupDto(StudentGroup studentGroup) {
		logger.trace("Called StudentGroupDto Constructor");
		
		this.studentGroupId = studentGroup.getStudentGroupId();
		this.groupName = studentGroup.getName();
		
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
	
}

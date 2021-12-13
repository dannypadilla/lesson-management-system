package com.dcp.slmanager.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentDto {
	
	private Integer id;
	private String name;
	private Integer birthYear;
	private String parentName;
	private String parentEmail;
	private Integer groupId;
	private String groupName;
	
	public StudentDto() {}
	
	private static Logger logger = LoggerFactory.getLogger(StudentDto.class);

	
	public StudentDto(Student student) {
		logger.trace("Called StudentDto Constructor");
		String msg = "StudentGroup is Empty";
		this.id = student.getStudentId();
		this.name = student.getName();
		this.birthYear = student.getBirthYear();
		this.parentName = student.getParentName();
		this.parentEmail = student.getParentEmail();
		if (student.getStudentGroup() != null) {
			this.groupId = student.getStudentGroup().getStudentGroupId();
			this.groupName = student.getStudentGroup().getName();
			msg = this.groupName;
		}
		logger.info(msg);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	
	

}

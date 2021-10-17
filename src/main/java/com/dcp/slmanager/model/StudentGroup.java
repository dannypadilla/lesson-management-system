package com.dcp.slmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_groups")
public class StudentGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer studentGroupId;
	private String name;
	
	public Integer getStudentGroupId() { return this.studentGroupId; }
	public String getName() { return this.name; }
	
	public void setStudentGroupId(Integer studentGroupId) { this.studentGroupId = studentGroupId; }
	public void setName(String name) { this.name = name; }
	

}
package com.dcp.slmanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_groups")
public class StudentGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer studentGroupId;
	private String name;
	
	@OneToMany(mappedBy = "studentGroup")
	private List<Student> studentList;

	public Integer getStudentGroupId() { return this.studentGroupId; }
	public String getName() { return this.name; }
	public List<Student> getStudentList() { return this.studentList; }
	
	public void setStudentGroupId(Integer studentGroupId) { this.studentGroupId = studentGroupId; }
	public void setName(String name) { this.name = name; }
	public void setStudentList(List<Student> studentList) { this.studentList = studentList; }
	
}
package com.dcp.slmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "students")
public class Student implements Serializable {
	
	private static Logger logger = LoggerFactory.getLogger(Student.class);

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer studentId;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "student_group_id")
	private StudentGroup studentGroup;
	
	// the function name determines the name in JSON output
	// if return var name != function name, will output later in JSON
	// {"studentId: 1", ...} V.S. {..., "studentId": 1}
	public Integer getStudentId() { return this.studentId; }
	public String getName() { return this.name; }
	
	public StudentGroup getStudentGroup() {
		logger.trace("Called GET StudentGroup");
		String msg = "StudentGroup is Empty";
		if (this.studentGroup != null) {
			msg = this.studentGroup.getName();
		}
		logger.info(msg);
		return this.studentGroup;
	}
	
	public void setStudentId(Integer studentId) {this.studentId = studentId;}
	public void setName(String name) {this.name = name;}
	public void setStudentGroup(StudentGroup studentGroup) {
		logger.trace("Called SET StudentGroup");
		String msg = "StudentGroup is Empty";
		if (this.studentGroup != null) {
			msg = this.studentGroup.getName();
		}
		logger.info(msg);
		this.studentGroup = studentGroup;
	}
	
	
}

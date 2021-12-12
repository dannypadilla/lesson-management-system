package com.dcp.slmanager.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.dao.StudentGroupDao;

@Repository
public class StudentGroupDaoImpl implements StudentGroupDao {
	
	private static Logger logger = LoggerFactory.getLogger(StudentGroupDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	StudentGroupDaoImpl() {
		logger.trace("Hi from StudentGROUPDaoImpl Constructor");
	}
	

	@Override
	public List<StudentGroup> getGroups() {
		List<StudentGroup> studentGroupList = this.entityManager.createQuery(
				"from StudentGroup", StudentGroup.class)
				.getResultList();
		return studentGroupList;
	}

	
	@Override
	public StudentGroup getStudentGroup(Integer id) {
		StudentGroup studentGroup = this.entityManager.find(StudentGroup.class, id);
		return studentGroup;
	}
	

	@Override
	@Transactional
	public StudentGroup saveStudentGroup(StudentGroup group) {
		return this.entityManager.merge(group);
	}

	/*
	@Override
	public List<Student> getStudents() {
		List<Student> studentList = this.entityManager.createQuery(
				"from Student", Student.class)
				.getResultList();
		return studentList;
	}
	*/

}

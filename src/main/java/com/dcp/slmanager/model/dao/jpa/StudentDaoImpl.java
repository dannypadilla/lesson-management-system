package com.dcp.slmanager.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.dao.StudentDao;


@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	StudentDaoImpl() {
		logger.trace("Hi from StudentDaoImpl Constructor");
	}
	
	@Override
	public List<Student> getStudents() {
		logger.trace("GetStudents list");
		return entityManager.createQuery(
					"from Student", Student.class
				).getResultList();
	}
	
	
	@Override
	public Student getStudent(Integer id) {
		logger.trace("getStudent by ID: " + id.toString() );
		return entityManager.find(Student.class, id);
	}
	
	
	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return entityManager.merge(student);
	}


	@Override
	public StudentGroup getGroup(Integer id) {
		logger.trace("GetGroup by ID: " + id.toString() );
		return this.entityManager.find(StudentGroup.class, id);
	}


	@Override
	public StudentGroup saveGroup(StudentGroup group) {
		return this.entityManager.merge(group);
	}

}
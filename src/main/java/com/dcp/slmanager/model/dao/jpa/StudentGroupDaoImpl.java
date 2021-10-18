package com.dcp.slmanager.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.dcp.slmanager.model.Student;
import com.dcp.slmanager.model.StudentGroup;
import com.dcp.slmanager.model.dao.StudentGroupDao;

public class StudentGroupDaoImpl implements StudentGroupDao {
	
	private static Logger logger = LoggerFactory.getLogger(StudentGroupDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	StudentGroupDaoImpl() {
		logger.trace("Hi from StudentGROUPDaoImpl Constructor");
	}
	

	@Override
	public List<StudentGroup> getGroups() {
		logger.trace("getStudentGroups List");
		String msg = "StudentGroups List is Empty";
		
		List<StudentGroup> studentGroupList = this.entityManager.createQuery(
				"from StudentGroup", StudentGroup.class)
				.getResultList();
		
		if ( !studentGroupList.isEmpty() ) {
			msg = "StudentGroupDaoImpl has data!";
		}
		logger.info(msg);
		return studentGroupList;
	}

	
	@Override
	public StudentGroup getGroup(Integer id) {
		
		logger.trace("GET (Student)Group");
		String msg = "StudentGroups List is Empty";
		
		StudentGroup studentGroup = this.entityManager.find(StudentGroup.class, id);
		
		if ( studentGroup != null ) {
			msg = "StudentGroupDaoImpl has data! \nName: " + studentGroup.getName();
		}
		logger.info(msg);
		
		return studentGroup;
	}
	

	@Override
	@Transactional
	public StudentGroup saveGroup(StudentGroup group) {
		return this.entityManager.merge(group);
	}

}

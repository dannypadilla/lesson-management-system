package com.dcp.slmanager.model.dao;

import java.util.List;

import com.dcp.slmanager.model.StudentGroup;

public interface StudentGroupDao {
	
	List<StudentGroup> getGroups();
	
	StudentGroup getGroup(Integer id);
	StudentGroup saveGroup(StudentGroup group);

}

package net.ashraff.taskmanager.dao;

import java.util.List;

import net.ashraff.taskmanager.entities.Resource;

public interface ResourceDao {
	
	void save(Resource nav);

	void update(Resource nav);

	public List<Resource> getResourceList();

	void delete(Resource id);

}

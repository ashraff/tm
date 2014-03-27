package net.ashraff.taskmanager.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.ashraff.taskmanager.entities.Resource;

public interface ResourceService {
	public List<Resource> getResourceAsList();

	public void augmentResults(List<Resource> content);

	public Boolean add(Resource res);

	public Boolean edit(Resource res);
	
	public Boolean delete(Resource id);
	
	// Read from service
	public Page<Resource> getList(Integer rows,Integer page, String sord,String filters);
	
}

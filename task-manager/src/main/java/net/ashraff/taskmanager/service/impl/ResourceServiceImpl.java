package net.ashraff.taskmanager.service.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.ashraff.taskmanager.dao.ResourceDao;
import net.ashraff.taskmanager.entities.Project;
import net.ashraff.taskmanager.entities.ProjectId;
import net.ashraff.taskmanager.entities.Resource;
import net.ashraff.taskmanager.service.ResourceService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.github.markserrano.jsonquery.jpa.enumeration.OrderEnum;
import com.github.markserrano.jsonquery.jpa.filter.JsonFilter;
import com.github.markserrano.jsonquery.jpa.mapper.JsonObjectMapper;
import com.github.markserrano.jsonquery.jpa.service.IFilterService;
import com.github.markserrano.jsonquery.jpa.specifier.Order;
import com.github.markserrano.jsonquery.jpa.util.QueryUtil;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.OrderSpecifier;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class ResourceServiceImpl implements ResourceService {

	private static final Logger LOG = Logger
			.getLogger(ResourceServiceImpl.class);

	@Autowired
	private ResourceDao resDao;

	@Autowired
	private IFilterService<Resource> filterService;

	public List<Resource> getResourceAsList() {
		List<Resource> resList = resDao.getResourceList();
		for (int i = 0; i < resList.size() && resList != null; i++) {
			Resource res = resList.get(i);
			if (res.getProject() != null)
				for (Project project : res.getProject()) {
					res.setProjectListAsString((res.getProjectListAsString() != null ? (res
							.getProjectListAsString() + ",") : "")
							+ project.getId().getName());
				}
		}
		return resList;
	}

	public void augmentResults(List<Resource> content) {
		for (int i = 0; i < content.size() && content != null; i++) {
			Resource res = content.get(i);
			if (res.getProject() != null)
				for (Project project : res.getProject()) {
					res.setProjectListAsString((res.getProjectListAsString() != null ? (res
							.getProjectListAsString() + ",") : "")
							+ project.getId().getName());
				}
		}
	}

	@CacheEvict(allEntries=true, value = { "resource" })
	@Override
	public Boolean add(Resource res) {
		LOG.debug("The value of Resource is : "
				+ ReflectionToStringBuilder.toString(res));
		List<String> projectList = Arrays.asList(res.getProjectListAsString()
				.split("\\s*,\\s*"));
		for (Iterator<String> iterator = projectList.iterator(); iterator
				.hasNext();) {
			String string = iterator.next();
			Project proj = new Project();
			proj.setId(new ProjectId());
			proj.getId().setName(string);
			proj.getId().setResource(res);
			proj.setDescription(string);
			res.getProject().add(proj);

		}
		resDao.save(res);
		return true;
	}

	@CacheEvict(allEntries=true, value = { "resource" })
	@Override
	public Boolean edit(Resource res) {
		LOG.debug("The value of Resource is : "
				+ ReflectionToStringBuilder.toString(res));
		List<String> projectList = Arrays.asList(res.getProjectListAsString()
				.split("\\s*,\\s*"));
		for (Iterator<String> iterator = projectList.iterator(); iterator
				.hasNext();) {
			String string = iterator.next();
			Project proj = new Project();
			proj.setId(new ProjectId());
			proj.getId().setName(string);
			proj.getId().setResource(res);
			proj.setDescription(string);
			res.getProject().add(proj);

		}
		resDao.update(res);
		return true;
	}
	@CacheEvict(allEntries=true, value = { "resource" })
	public Boolean delete(Resource res) {
		LOG.debug("The value of Resource is : "
				+ ReflectionToStringBuilder.toString(res));
		resDao.delete(res);
		return true;
	}

	@Override
	@Cacheable("resource")
	public Page<Resource> getList(Integer rows, Integer page, String sord,
			String filters) {
		Order order = new Order(Resource.class);

		// Prepare arguments before reading from service
		Pageable pageable = new PageRequest(page - 1, rows);
		OrderSpecifier<?> orderSpecifier = order.by("id",
				OrderEnum.getEnum(sord));

		if (filters == null || StringUtils.isEmpty(filters)) {
			filters = QueryUtil.init();
		}

		JsonFilter filter = JsonObjectMapper.map(filters);

		BooleanBuilder booleanBuilder = filterService.getJsonBooleanBuilder(
				Resource.class).buildRecusively(filter, null);

		// Read from service
		Page<Resource> results = filterService.readAndCount(booleanBuilder,
				pageable, Resource.class, orderSpecifier);
		
		augmentResults(results.getContent());
		
		return results;
	}

}

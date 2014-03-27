package net.ashraff.taskmanager.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ashraff.taskmanager.dao.ResourceDao;
import net.ashraff.taskmanager.entities.Resource;

@Repository
public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Resource nav) {
		sessionFactory.getCurrentSession().save(nav);
	}

	@Override
	public void update(Resource nav) {
		sessionFactory.getCurrentSession().update(nav);

	}

	@Override
	public void delete(Resource res) {
		Resource dbRes = (Resource) sessionFactory.getCurrentSession().get(Resource.class, res.getId());
		sessionFactory.getCurrentSession().delete(dbRes);

	}

	@Override
	public List<Resource> getResourceList() {
		@SuppressWarnings("unchecked")
		List<Resource> list = sessionFactory.getCurrentSession()
				.createQuery("from Resource f").list();
		return list;
	}

}

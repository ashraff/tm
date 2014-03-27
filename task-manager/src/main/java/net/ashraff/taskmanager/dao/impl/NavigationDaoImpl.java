package net.ashraff.taskmanager.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ashraff.taskmanager.dao.NavigationDao;
import net.ashraff.taskmanager.entities.Navigation;

@Repository
public class NavigationDaoImpl implements NavigationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Navigation nav) {
		sessionFactory.getCurrentSession().save(nav);
	}

	@Override
	public void update(Navigation nav) {
		sessionFactory.getCurrentSession().update(nav);
	}

	@Override
	public void delete(Navigation nav) {
		sessionFactory.getCurrentSession().delete(nav);
	}

	@Override
	public List<Navigation> getNavListUserId(int userId) {
		@SuppressWarnings("unchecked")
		List<Navigation> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Navigation where serviceId is null or userId=:id order by menuOrder")
				.setParameter("id", userId).list();
		return list;
	}

}

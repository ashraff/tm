package net.ashraff.taskmanager.dao;

import java.util.List;

import net.ashraff.taskmanager.entities.Navigation;

public interface NavigationDao {

	void save(Navigation nav);

	void update(Navigation nav);

	void delete(Navigation nav);

	public List<Navigation> getNavListUserId(int userId);

}

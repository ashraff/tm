package net.ashraff.taskmanager.service;

import java.util.List;

import net.ashraff.taskmanager.datastructure.Tree;
import net.ashraff.taskmanager.entities.Navigation;

public interface NavigationService {

	public Tree<Navigation> getNavigationMenu(int userId);
	public List<Navigation> getNavigationMenuAsList(int userId);
}

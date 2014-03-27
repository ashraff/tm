package net.ashraff.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.ashraff.taskmanager.dao.NavigationDao;
import net.ashraff.taskmanager.datastructure.Tree;
import net.ashraff.taskmanager.entities.Navigation;
import net.ashraff.taskmanager.service.NavigationService;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NavigationServiceImpl implements NavigationService {

	private static final Logger LOG = Logger
			.getLogger(NavigationServiceImpl.class);

	@Autowired
	private NavigationDao navDao;

	@Inject
	public NavigationServiceImpl(NavigationDao navDao) {
		this.navDao = navDao;
	}

	@Override
	public Tree<Navigation> getNavigationMenu(int userId) {
		boolean treeCreated = false;
		Navigation rootNode = new Navigation();
		Tree<Navigation> navTree = new Tree<Navigation>(rootNode);
		List<Navigation> navList = navDao.getNavListUserId(userId);
		HashMap<Navigation, Boolean> navTreeMap = new HashMap<Navigation, Boolean>();
		if (navList != null)
			for (Navigation navigation : navList) {
				if (navigation.getServiceId() == null
						&& navigation.getParentId() == null) {
					navTree.addLeaf(rootNode, navigation);
				} else if (navigation.getServiceId() != null
						&& navigation.getParentId() == null) {
					navTree.addLeaf(rootNode, navigation);
				} else
					navTreeMap.put(navigation, false);
			}

		while (!treeCreated) {
			Iterator<Entry<Navigation, Boolean>> it = navTreeMap.entrySet()
					.iterator();
			while (it.hasNext()) {
				Entry<Navigation, Boolean> entry = it.next();
				Navigation nav = entry.getKey();
				if (!entry.getValue()) {
					Navigation rootFinder = new Navigation();
					rootFinder.setId(nav.getParentId());
					if (navTree.getTree(rootFinder) != null) {
						navTree.getTree(rootFinder).addLeaf(nav);
						it.remove();
					}
				}
				treeCreated = (navTreeMap.size() == 0);
			}
		}
		LOG.info(navTree.toString());
		return navTree;
	}

	@Override
	public List<Navigation> getNavigationMenuAsList(int userId) {
		boolean treeCreated = false;
		List<Navigation> navigationList = new ArrayList<Navigation>();
		List<Navigation> navList = navDao.getNavListUserId(userId);
		HashMap<Navigation, Boolean> navTreeMap = new HashMap<Navigation, Boolean>();
		if (navList != null)
			for (Navigation navigation : navList) {
				if (navigation.getServiceId() == null
						&& navigation.getParentId() == null) {
					navigationList.add(navigation);
				} else if (navigation.getServiceId() != null
						&& navigation.getParentId() == null) {
					navigationList.add(navigation);
				} else
					navTreeMap.put(navigation, false);
			}

		while (!treeCreated && navTreeMap.size() > 0) {
			Iterator<Entry<Navigation, Boolean>> it = navTreeMap.entrySet()
					.iterator();
			while (it.hasNext()) {
				Entry<Navigation, Boolean> entry = it.next();
				Navigation nav = entry.getKey();
				if (!entry.getValue()) {

					for (Iterator<Navigation> iterator = navigationList
							.iterator(); iterator.hasNext();) {
						Navigation navigation = iterator.next();
						if (navigation.getId() == nav.getParentId()) {
							if (navigation.getChildItems() == null)
								navigation
										.setChildItems(new ArrayList<Navigation>());
							navigation.getChildItems().add(nav);
							it.remove();
						}
					}

				}
				treeCreated = (navTreeMap.size() == 0);
			}
		}
		LOG.info(navigationList);
		return navigationList;
	}
}

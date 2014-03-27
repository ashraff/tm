package net.ashraff.taskmanager.entities;

import java.util.List;

import javax.persistence.Transient;

public class Navigation {

	int id;
	Integer serviceId;
	Integer parentId;
	Integer userId;
	String displayTxtId;
	String tooltipTxtId;
	String url;
	String serviceName;
	String action;
	String menuText;
	String menuTooltipText;
	Integer selected;
	Integer menuOrder;
	@Transient
	private List<Navigation> childItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDisplayTxtId() {
		return displayTxtId;
	}

	public void setDisplayTxtId(String displayTxtId) {
		this.displayTxtId = displayTxtId;
	}

	public String getTooltipTxtId() {
		return tooltipTxtId;
	}

	public void setTooltipTxtId(String tooltipTxtId) {
		this.tooltipTxtId = tooltipTxtId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMenuText() {
		return menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getMenuTooltipText() {
		return menuTooltipText;
	}

	public void setMenuTooltipText(String menuTooltipText) {
		this.menuTooltipText = menuTooltipText;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public List<Navigation> getChildItems() {
		return childItems;
	}

	public void setChildItems(List<Navigation> childItems) {
		this.childItems = childItems;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Navigation) obj).id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "-" + this.getDisplayTxtId();
	}

}

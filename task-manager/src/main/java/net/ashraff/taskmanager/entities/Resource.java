package net.ashraff.taskmanager.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6284978333138145249L;
	Integer id;
	String resourceName;
	String resourceEmail;
	String primarySkill;
	String secondarySkill;
	String tertiarySkill;
	String soeId;
	@Transient
	String projectListAsString;
	@JsonManagedReference
	Set<Project> project = new HashSet<Project>(0);
	Integer versionNo;

	public Resource() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceEmail() {
		return resourceEmail;
	}

	public void setResourceEmail(String resourceEmail) {
		this.resourceEmail = resourceEmail;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	public String getTertiarySkill() {
		return tertiarySkill;
	}

	public void setTertiarySkill(String tertiarySkill) {
		this.tertiarySkill = tertiarySkill;
	}

	public String getSoeId() {
		return soeId;
	}

	public void setSoeId(String soeId) {
		this.soeId = soeId;
	}

	public String getProjectListAsString() {
		return projectListAsString;
	}

	public void setProjectListAsString(String projectListAsString) {
		this.projectListAsString = projectListAsString;
	}

	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Resource))
			return false;

		Resource rhs = (Resource) obj;
		return new EqualsBuilder().append(id, rhs.getId()).isEquals();
	}

}

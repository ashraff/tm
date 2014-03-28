package net.ashraff.taskmanager.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

import net.sf.ehcache.pool.sizeof.annotations.IgnoreSizeOf;

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
	private Integer id;
	private String resourceName;
	private String resourceEmail;
	private String primarySkill;
	private String secondarySkill;
	private String tertiarySkill;
	private String soeId;
	@Transient
	private String projectListAsString;
	@IgnoreSizeOf 
	@JsonManagedReference
	private Set<Project> project = new HashSet<Project>(0);
	private Integer versionNo;
	private Date dateStart;
	private Date dateEnd;

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

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
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

package net.ashraff.taskmanager.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ProjectId implements Serializable {
	private static final long serialVersionUID = 6911616314813390449L;
	private String name;
	@JsonBackReference
	private Resource resource;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(getResource().getId())
				.append(getName()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof ProjectId))
			return false;

		ProjectId rhs = (ProjectId) obj;
		return new EqualsBuilder().append(getName(), rhs.getName())
				.append(getResource().getId(), rhs.getResource().getId())
				.isEquals();
	}

}

package net.ashraff.taskmanager.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	String description;
	private ProjectId id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectId getId() {
		return id;
	}

	public void setId(ProjectId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder(17, 31).append(id.getResource().getId())
				.append(id.getName()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Project))
			return false;

		Project rhs = (Project) obj;
		return new EqualsBuilder()
				.append(id.getName(), rhs.getId().getName())
				.append(id.getResource().getId(),
						rhs.getId().getResource().getId()).isEquals();
	}

}

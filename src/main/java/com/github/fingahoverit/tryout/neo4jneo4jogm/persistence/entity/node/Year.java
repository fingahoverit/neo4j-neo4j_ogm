package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Year {

	@GraphId
	protected Long id;

	private Integer year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[year:").append(getYear()).append("]");

		return sb.toString();
	}
}

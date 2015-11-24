package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Squad")
public class Squad {

	@GraphId
	protected Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[name:").append(getName()).append("]");

		return sb.toString();
	}
}

package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Time {

	@GraphId
	private Long id;

	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[time:").append(getTime()).append("]");

		return sb.toString();
	}
}

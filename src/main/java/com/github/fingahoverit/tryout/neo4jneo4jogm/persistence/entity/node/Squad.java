package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Squad")
public class Squad {

	@GraphId
	protected Long id;

	private String name;

	@Relationship(type = "FOR_WORLD_CUP", direction = Relationship.OUTGOING)
	private List<WorldCup> worldCupList = new ArrayList<WorldCup>();

	@Relationship(type = "NAMED_SQUAD", direction =  Relationship.INCOMING)
	List<Country> country = new ArrayList<Country>();

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

	public List<WorldCup> getWorldCupList() {
		return worldCupList;
	}

	public void setWorldCupList(List<WorldCup> worldCupList) {
		this.worldCupList = worldCupList;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[name:").append(getName()).append("]");

		return sb.toString();
	}
}

package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class WorldCup {

	@GraphId
	protected Long id;

	private String name;

	private Integer year;

	@Relationship(type = "CONTAINS_MATCH", direction = Relationship.OUTGOING)
	private List<Match> matchList = new ArrayList<Match>();

	@Relationship(type = "IN_YEAR", direction = Relationship.OUTGOING)
	private List<Year> yearList = new ArrayList<Year>();

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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}

	public List<Year> getYearList() {
		return yearList;
	}

	public void setYearList(List<Year> yearList) {
		this.yearList = yearList;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[name:").append(getName()).append("]");
		sb.append("[year:").append(getYear()).append("]");

		return sb.toString();
	}
}

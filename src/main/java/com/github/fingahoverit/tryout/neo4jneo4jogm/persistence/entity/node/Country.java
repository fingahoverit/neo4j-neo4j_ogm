package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Country")
public class Country {

	@GraphId
	protected Long id;

	private String name;

	@Property(name = "lon")
	private Double longitude;

	@Property(name = "lat")
	private Double lattitude;

	@Relationship(type = "NAMED_SQUAD", direction = Relationship.OUTGOING)
	private List<Squad> squadList = new ArrayList<Squad>();

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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public List<Squad> getSquadList() {
		return squadList;
	}

	public void setSquadList(List<Squad> squadList) {
		this.squadList = squadList;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[name:").append(getName()).append("]");
		sb.append("[longitude:").append(getLongitude()).append("]");
		sb.append("[lattitude:").append(getLattitude()).append("]");

		return sb.toString();
	}
}

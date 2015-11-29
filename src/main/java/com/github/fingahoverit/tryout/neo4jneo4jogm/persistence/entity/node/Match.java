package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Match {

	@GraphId
	private Long id;

	@Property(name = "id")
	private String matchId;

	@Property(name = "a_score")
	private String awayScore;

	@Property(name = "h_score")
	private String homeScore;

	private String description;

	private String attendance;

	private Integer number;

	private String date;

	@Relationship(type = "HOME_TEAM", direction = Relationship.OUTGOING)
	private List<Country> homeTeamCountryList = new ArrayList<Country>();

	@Relationship(type = "AWAY_TEAM", direction = Relationship.OUTGOING)
	private List<Country> awayTeamCountryList = new ArrayList<Country>();

	@Relationship(type = "IN_PHASE", direction = Relationship.OUTGOING)
	private List<Phase> phaseList = new ArrayList<Phase>();

	@Relationship(type = "PLAYED_IN_STADIUM", direction = Relationship.OUTGOING)
	private List<Stadium> stadiumList = new ArrayList<Stadium>();

	@Relationship(type = "PLAYED_AT_TIME", direction = Relationship.OUTGOING)
	private List<Time> timeList = new ArrayList<Time>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(String awayScore) {
		this.awayScore = awayScore;
	}

	public String getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Country> getHomeTeamCountryList() {
		return homeTeamCountryList;
	}

	public void setHomeTeamCountryList(List<Country> homeTeamCountryList) {
		this.homeTeamCountryList = homeTeamCountryList;
	}

	public List<Country> getAwayTeamCountryList() {
		return awayTeamCountryList;
	}

	public void setAwayTeamCountryList(List<Country> awayTeamCountryList) {
		this.awayTeamCountryList = awayTeamCountryList;
	}

	public List<Phase> getPhaseList() {
		return phaseList;
	}

	public void setPhaseList(List<Phase> phaseList) {
		this.phaseList = phaseList;
	}

	public List<Stadium> getStadiumList() {
		return stadiumList;
	}

	public void setStadiumList(List<Stadium> stadiumList) {
		this.stadiumList = stadiumList;
	}

	public List<Time> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Time> timeList) {
		this.timeList = timeList;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[matchId:").append(getMatchId()).append("]");
		sb.append("[awayScore:").append(getAwayScore()).append("]");
		sb.append("[homeScore:").append(getHomeScore()).append("]");
		sb.append("[description:").append(getDescription()).append("]");
		sb.append("[attendance:").append(getAttendance()).append("]");
		sb.append("[number:").append(getNumber()).append("]");
		sb.append("[date:").append(getDate()).append("]");

		return sb.toString();
	}
}

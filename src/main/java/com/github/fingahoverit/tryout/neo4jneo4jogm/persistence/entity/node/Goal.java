package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Goal {

	@GraphId
	private Long id;

	private Integer time;

	@Property(name = "match_id")
	private Integer matchId;

	@Property(name = "player_id")
	private String playerId;

	private String goal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[time:").append(getTime()).append("]");
		sb.append("[matchId:").append(getMatchId()).append("]");
		sb.append("[playerId:").append(getPlayerId()).append("]");
		sb.append("[goal:").append(getGoal()).append("]");

		return sb.toString();
	}
}

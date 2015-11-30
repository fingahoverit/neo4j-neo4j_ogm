package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Goal {

	@GraphId
	private Long id;

	private String time;

	@Property(name = "match_id")
	private String matchId;

	@Property(name = "player_id")
	private String playerId;

	private String type;

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

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[time:").append(getTime()).append("]");
		sb.append("[matchId:").append(getMatchId()).append("]");
		sb.append("[playerId:").append(getPlayerId()).append("]");
		sb.append("[type:").append(getType()).append("]");

		return sb.toString();
	}
}

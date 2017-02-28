package com.github.fingahoverit.tryout.neo4jneo4jogm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.demo.CypherQuery;
import com.github.fingahoverit.tryout.neo4jneo4jogm.demo.EntityQuery;

public class WorldCupDemo {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(WorldCupDemo.class);

	public static void main(String[] args) {

		LOGGER.info("loadCountryParaguay");
		EntityQuery.loadCountryParaguay();
		// EntityQuery.loadPlayerPlatini();
		// EntityQuery.loadPlayerMichel();
		// EntityQuery.loadFrenchPlayers();
		// EntityQuery.addCheatGoalPlatini();
		// EntityQuery.deleteCheatGoal();

		// CypherQuery.loadCountryParaguay();
		CypherQuery.loadPlayerPlatini();
		// CypherQuery.loadPlayerMichel();
		CypherQuery.loadFrenchPlayers();
		// CypherQuery.addCheatGoalPlatini();
		// CypherQuery.deleteCheatGoal();
		// CypherQuery.setPlayerFirstLastName();
		// CypherQuery.removePlayerFirstLastName();
	}

}

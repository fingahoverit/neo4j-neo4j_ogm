package com.github.fingahoverit.tryout.neo4jneo4jogm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.demo.EntityQuery;

public class WorldCupDemo {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(WorldCupDemo.class);

	public static void main(String[] args) {

		LOGGER.info("EntityQuery.loadCountryParaguay");
		EntityQuery.loadCountryParaguay();
		// LOGGER.info("EntityQuery.loadPlayerPlatini");
		// EntityQuery.loadPlayerPlatini();
		// LOGGER.info("EntityQuery.loadPlayerMichel");
		// EntityQuery.loadPlayerMichel();
		// LOGGER.info("EntityQuery.addCheatGoalPlatini");
		// EntityQuery.addCheatGoalPlatini();
		// LOGGER.info("EntityQuery.deleteCheatGoal");
		// EntityQuery.deleteCheatGoal();

		// LOGGER.info("CypherQuery.loadCountryParaguay");
		// CypherQuery.loadCountryParaguay();
		// LOGGER.info("CypherQuery.loadPlayerPlatini");
		// CypherQuery.loadPlayerPlatini();
		// LOGGER.info("CypherQuery.loadFrenchPlayers");
		// CypherQuery.loadFrenchPlayers();
		// LOGGER.info("CypherQuery.addCheatGoalPlatini");
		// CypherQuery.addCheatGoalPlatini();
		// LOGGER.info("CypherQuery.deleteCheatGoal");
		// CypherQuery.deleteCheatGoal();
		// LOGGER.info("CypherQuery.setPlayerFirstLastName");
		// CypherQuery.setPlayerFirstLastName();
		// LOGGER.info("CypherQuery.removePlayerFirstLastName");
		// CypherQuery.removePlayerFirstLastName();
	}

}

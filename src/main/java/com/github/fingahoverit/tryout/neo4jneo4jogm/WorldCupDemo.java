package com.github.fingahoverit.tryout.neo4jneo4jogm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.demo.CypherQuery;

public class WorldCupDemo {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(WorldCupDemo.class);

	public static void main(String[] args) {

		// EntityQuery.loadCountryParaguay();

		CypherQuery.loadCountryParaguay();
	}

}

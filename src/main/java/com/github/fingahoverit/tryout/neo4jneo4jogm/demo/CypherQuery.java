package com.github.fingahoverit.tryout.neo4jneo4jogm.demo;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Country;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Match;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Phase;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Squad;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Stadium;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.WorldCup;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.utils.SessionHelper;

public class CypherQuery {
	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(CypherQuery.class);

	// Utils class, no constructor
	private CypherQuery() {

	}

	public static void loadCountryParaguay() {

		Session session = SessionHelper.getSession();

		String query = "MATCH (e:Country) WHERE e.name = {countryName} RETURN e";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countryName", "Paraguay");

		Iterable<Country> countryCollection = session.query(Country.class, query, params);

		for (Country country : countryCollection) {

			LOGGER.info(MessageFormat.format("Country: {0}", country.toString()));

			for (Squad squad : country.getSquadList()) {
				LOGGER.info(MessageFormat.format("[-NAMED_SQUAD->{0}]", squad.toString()));

				for (WorldCup worldCup : squad.getWorldCupList()) {
					LOGGER.info(MessageFormat.format("[-FOR_WORLD_CUP->{0}]", worldCup.toString()));
				}
			}

			for (Match match : country.getMatchList()) {
				LOGGER.info(MessageFormat.format("[-PLAYED_IN->{0}]", match.toString()));

				for (Country homeCountry : match.getHomeTeamCountryList()) {
					LOGGER.info(MessageFormat.format("[-HOME_TEAM->{0}]", homeCountry.toString()));
				}

				for (Country awayCountry : match.getAwayTeamCountryList()) {
					LOGGER.info(MessageFormat.format("[-AWAY_TEAM->{0}]", awayCountry.toString()));
				}

				for (Phase phase : match.getPhaseList()) {
					LOGGER.info(MessageFormat.format("[-IN_PHASE->{0}]", phase.toString()));
				}

				for (Stadium stadium : match.getStadiumList()) {
					LOGGER.info(MessageFormat.format("[-PLAYED_IN_STADIUM->{0}]", stadium.toString()));
				}
			}

		}

		SessionHelper.closeSession();
	}
}

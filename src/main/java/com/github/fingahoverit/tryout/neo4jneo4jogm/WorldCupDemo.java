package com.github.fingahoverit.tryout.neo4jneo4jogm;

import java.util.Collection;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
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

public class WorldCupDemo {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(WorldCupDemo.class);

	public static void main(String[] args) {

		Session session = SessionHelper.getSession();

		Collection<Country> countryCollection = session.loadAll(Country.class,
				new Filters().add(new Filter("name", "Paraguay")), 2);

		for (Country country : countryCollection) {

			StringBuilder sb = new StringBuilder();
			sb.append("Country : ").append(country.toString());

			LOGGER.info(sb.toString());

			for (Squad squad : country.getSquadList()) {
				sb.setLength(0);
				sb.append("[-NAMED_SQUAD->").append(squad.toString()).append("]");
				LOGGER.info(sb.toString());

				for (WorldCup worldCup : squad.getWorldCupList()) {
					sb.setLength(0);
					sb.append("[-FOR_WORLD_CUP->").append(worldCup.toString()).append("]");
					LOGGER.info(sb.toString());
				}
			}

			for (Match match : country.getMatchList()) {
				sb.setLength(0);
				sb.append("[-PLAYED_IN->").append(match.toString()).append("]");
				LOGGER.info(sb.toString());

				for (Country homeCountry : match.getHomeTeamCountryList()) {
					sb.setLength(0);
					sb.append("[-HOME_TEAM->").append(homeCountry.toString()).append("]");
					LOGGER.info(sb.toString());
				}

				for (Country awayCountry : match.getAwayTeamCountryList()) {
					sb.setLength(0);
					sb.append("[-AWAY_TEAM->").append(awayCountry.toString()).append("]");
					LOGGER.info(sb.toString());
				}

				for (Phase phase : match.getPhaseList()) {
					sb.setLength(0);
					sb.append("[-IN_PHASE->").append(phase.toString()).append("]");
					LOGGER.info(sb.toString());
				}

				for (Stadium stadium : match.getStadiumList()) {
					sb.setLength(0);
					sb.append("[-PLAYED_IN_STADIUM->").append(stadium.toString()).append("]");
					LOGGER.info(sb.toString());
				}
			}

		}

		SessionHelper.closeSession();
	}

}

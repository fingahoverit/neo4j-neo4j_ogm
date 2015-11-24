package com.github.fingahoverit.tryout.neo4jneo4jogm;

import java.util.Collection;

import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Country;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Squad;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.utils.SessionHelper;

public class WorldCupDemo {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(WorldCupDemo.class);

	public static void main(String[] args) {

		Session session = SessionHelper.getSession();

		Collection<Country> countryCollection = session.loadAll(Country.class,
				new Filters().add(new Filter("name", "Paraguay")));

		for (Country country : countryCollection) {

			StringBuilder sb = new StringBuilder();
			sb.append("Country : ").append(country.toString());

			for (Squad squad : country.getSquadList()) {
				sb.append("[-NAMED_SQUAD->").append(squad.toString()).append("]");
			}

			LOGGER.info(sb.toString());
		}

		SessionHelper.closeSession();
	}

}

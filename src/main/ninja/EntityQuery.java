package com.github.fingahoverit.tryout.neo4jneo4jogm.demo;

import java.text.MessageFormat;
import java.util.Collection;

import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Country;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Goal;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Match;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Phase;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Player;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Squad;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.Stadium;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node.WorldCup;
import com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.utils.SessionHelper;

public class EntityQuery {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(EntityQuery.class);

	// Utils class, no constructor
	private EntityQuery() {

	}

	/**
	 * Load Country entity for "Paraguay"
	 */
	public static void loadCountryParaguay() {

		Session session = SessionHelper.getSession();

		Collection<Country> countryCollection = session.loadAll(Country.class,
				new Filters().add(new Filter("name", "Paraguay")), 2);

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

	/**
	 * Load every Player entity which has name "Michel Platini"
	 */
	public static void loadPlayerPlatini() {

		Session session = SessionHelper.getSession();

		Collection<Player> playerCollection = session.loadAll(Player.class,
				new Filters().add(new Filter("name", "Michel Platini")), 1);

		for (Player player : playerCollection) {

			LOGGER.info(MessageFormat.format("Player: {0}", player.toString()));

			for (Squad squad : player.getSquadList()) {
				LOGGER.info(MessageFormat.format("[-IN_SQUAD->{0}]", squad.toString()));
			}
		}

		SessionHelper.closeSession();
	}

	/**
	 * Load every Player entity which has "Michel" as firstname
	 */
	public static void loadPlayerMichel() {

		Session session = SessionHelper.getSession();

		Filter matchFilter = new Filter("name", "Michel.*");
		matchFilter.setComparisonOperator(ComparisonOperator.MATCHES);
		Collection<Player> playerCollection = session.loadAll(Player.class, new Filters().add(matchFilter), 1);

		for (Player player : playerCollection) {

			LOGGER.info(MessageFormat.format("Player: {0}", player.toString()));

			for (Squad squad : player.getSquadList()) {
				LOGGER.info(MessageFormat.format("[-IN_SQUAD->{0}]", squad.toString()));
			}
		}

		SessionHelper.closeSession();
	}

	/**
	 * Add a cheat goal to Platini
	 */
	public static void addCheatGoalPlatini() {

		Session session = SessionHelper.getSession();

		Goal newGoal = new Goal();
		newGoal.setMatchId("914");
		newGoal.setPlayerId("28528");
		newGoal.setTime("60");
		newGoal.setType("cheat");

		session.save(newGoal);

		// Check goal insertion
		Filter goalFilter = new Filter("player_id", "28528");
		Collection<Goal> goalCollection = session.loadAll(Goal.class, new Filters().add(goalFilter), 1);

		for (Goal goal : goalCollection) {
			LOGGER.info(MessageFormat.format("Goal: {0}", goal.toString()));
		}

		SessionHelper.closeSession();
	}

	/**
	 * Delete that cheat goal of Platini
	 */
	public static void deleteCheatGoal() {

		Session session = SessionHelper.getSession();

		// Goal to delete
		Collection<Goal> goalToDeleteCollection = session.loadAll(Goal.class,
				new Filters().add(new Filter("type", "cheat")), 1);

		for (Goal goal : goalToDeleteCollection) {
			session.delete(goal);
		}

		// Check goal deletion
		Collection<Goal> goalCollection = session.loadAll(Goal.class,
				new Filters().add(new Filter("player_id", "28528")), 1);

		for (Goal goal : goalCollection) {
			LOGGER.info(MessageFormat.format("Goal: {0}", goal.toString()));
		}

		SessionHelper.closeSession();
	}
}

package com.github.fingahoverit.tryout.neo4jneo4jogm.demo;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.result.Result;
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

public class CypherQuery {
	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(CypherQuery.class);

	// Utils class, no constructor
	private CypherQuery() {

	}

	/**
	 * Load Country entity for "Paraguay"
	 */
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

	/**
	 * Load every Player entity which has name "Michel Platini"
	 */
	public static void loadPlayerPlatini() {

		Session session = SessionHelper.getSession();

		String query = "MATCH (e:Player) WHERE e.name = {playerName} RETURN e";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("playerName", "Michel Platini");

		Iterable<Player> playerCollection = session.query(Player.class, query, params);

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

		String query = "MATCH (e:Player) WHERE e.name =~ {playerName} RETURN e";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("playerName", "Michel.*");

		Iterable<Player> playerCollection = session.query(Player.class, query, params);

		for (Player player : playerCollection) {

			LOGGER.info(MessageFormat.format("Player: {0}", player.toString()));

			for (Squad squad : player.getSquadList()) {
				LOGGER.info(MessageFormat.format("[-IN_SQUAD->{0}]", squad.toString()));
			}
		}

		SessionHelper.closeSession();
	}
	
	/**
	 * Load every French Player entity
	 */
	public static void loadFrenchPlayers() {

		Session session = SessionHelper.getSession();

		String query = "MATCH (p:Player) -[:IN_SQUAD]-> () <-[:NAMED_SQUAD]- (c:Country {name:{countryName}}) return p";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countryName", "France");

		Iterable<Player> playerCollection = session.query(Player.class, query, params);

		for (Player player : playerCollection) {

			LOGGER.info(MessageFormat.format("Player: {0}", player.toString()));
		}

		SessionHelper.closeSession();
	}
	
	
	/**
	 * Add a cheat goal to Platini
	 */
	public static void addCheatGoalPlatini() {

		Session session = SessionHelper.getSession();

		String queryCreate = "CREATE (g:Goal { time : '60', match_id : '914', player_id : '28528', type : 'cheat' })";

		session.query(queryCreate, Collections.<String, Object> emptyMap());

		// Check goal insertion
		String queryCheck = "MATCH (g:Goal { player_id : '28528'}) RETURN g";
		Iterable<Goal> goalCollection = session.query(Goal.class, queryCheck, Collections.<String, Object> emptyMap());

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
		String queryDelete = "MATCH (g:Goal { type : 'cheat' }) DELETE g";

		session.query(queryDelete, Collections.<String, Object> emptyMap());

		// Check goal deletion
		String queryCheck = "MATCH (g:Goal { player_id : '28528'}) RETURN g";
		Iterable<Goal> goalCollection = session.query(Goal.class, queryCheck, Collections.<String, Object> emptyMap());

		for (Goal goal : goalCollection) {
			LOGGER.info(MessageFormat.format("Goal: {0}", goal.toString()));
		}

		SessionHelper.closeSession();
	}

	/**
	 * Define first name and Last name to players
	 */
	public static void setPlayerFirstLastName() {

		Session session = SessionHelper.getSession();

		String querySet = "MATCH (p:Player) SET p.firstName = SPLIT(p.name, ' ')[0], p.lastName = UPPER(SPLIT(p.name, ' ')[1]) ";

		session.query(querySet, Collections.<String, Object> emptyMap());

		// Check player update
		String queryCheck = "MATCH (p:Player) RETURN p";
		Result result = session.query(queryCheck, Collections.<String, Object> emptyMap());
		Iterator<Map<String, Object>> resultIterator = result.queryResults().iterator();

		while (resultIterator.hasNext()) {
			LOGGER.info("Player : " + resultIterator.next().toString());
		}

		SessionHelper.closeSession();
	}

	/**
	 * Remove first name and Last name property to players
	 */
	public static void removePlayerFirstLastName() {

		Session session = SessionHelper.getSession();

		String queryRemove = "MATCH (p:Player) REMOVE p.firstname, p.lastName ";

		session.query(queryRemove, Collections.<String, Object> emptyMap());

		// Check player update
		String queryCheck = "MATCH (p:Player) RETURN p";
		Result result = session.query(queryCheck, Collections.<String, Object> emptyMap());
		Iterator<Map<String, Object>> resultIterator = result.queryResults().iterator();

		while (resultIterator.hasNext()) {
			LOGGER.info("Player : " + resultIterator.next().toString());
		}

		SessionHelper.closeSession();
	}
}

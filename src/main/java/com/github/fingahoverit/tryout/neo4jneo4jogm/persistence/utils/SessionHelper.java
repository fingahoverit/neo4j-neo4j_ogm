package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.utils;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.transaction.Transaction;

public class SessionHelper {

	/** static entity manager. */
	private static Session SESSION = null;

	/** package for node entity to load. */
	private static String NODE_PACKAGE = "com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node";

	/** package for relationship entity to load. */
	private static String RELATIONSHIP_PACKAGE = "com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.relationship";

	/** URL to Neo4j db. */
	private static String NEO4J_URL = "http://localhost:7474";

	/** User of Neo4j db. */
	private static String NEO4J_USER = "neo4j";

	/** Password for Neo4j db User. */
	private static String NEO4J_PASSWORD = "password";

	/**
	 * Return current entity manager or create a new one if null.
	 * 
	 * @return active entity manager.
	 */
	public static Session getSession() {

		if (SESSION == null) {

			synchronized (SessionHelper.class) {
				// Thread Safe
				if (SESSION == null) {
					SessionFactory sessionFactory = new SessionFactory(NODE_PACKAGE);
					SESSION = sessionFactory.openSession(NEO4J_URL, NEO4J_USER, NEO4J_PASSWORD);

					SESSION.beginTransaction();
				}
			}

			return SESSION;
		} else

		{
			return SESSION;
		}

	}

	/**
	 * Close current entity manager.
	 */
	public static void closeSession() {
		if (SESSION != null) {

			synchronized (SessionHelper.class) {
				// Thread Safe

				if (SESSION != null) {
					Transaction tx = SESSION.getTransaction();
					tx.commit();
					tx.close();

					SESSION = null;
				}
			}
		}
	}
}

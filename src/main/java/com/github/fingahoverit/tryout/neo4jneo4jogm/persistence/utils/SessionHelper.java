package com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.utils;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;

public class SessionHelper {

	/** static entity manager. */
	private static Session SESSION = null;

	/** package for node entity to load. */
	private static String NODE_PACKAGE = "com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.node";

	/** package for relationship entity to load. */
	private static String RELATIONSHIP_PACKAGE = "com.github.fingahoverit.tryout.neo4jneo4jogm.persistence.entity.relationship";

	/** URL to Neo4j db. */
	private static String NEO4J_DOMAIN = "localhost";
	private static String NEO4J_PORT = "7474";

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

					Configuration configuration = new Configuration();
					configuration.driverConfiguration()
							.setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver").setURI("http://"
									+ NEO4J_USER + ":" + NEO4J_PASSWORD + "@" + NEO4J_DOMAIN + ":" + NEO4J_PORT + "");

					SessionFactory sessionFactory = new SessionFactory(configuration, NODE_PACKAGE,
							RELATIONSHIP_PACKAGE);
					SESSION = sessionFactory.openSession();

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

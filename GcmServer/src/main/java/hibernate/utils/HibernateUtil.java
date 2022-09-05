package main.java.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session = null;

    public static void startSession() {
	// create configurations
	Configuration configuration = new Configuration();
	configuration.configure("/main/resources/hibernate.cfg.xml");

	// crate session factory - data source
	SessionFactory sessionFactory = configuration.buildSessionFactory();

	// initialize session object
	session = sessionFactory.openSession();

	if (!session.isOpen()) {
	    System.out.println("Unable to open session!");
	} else {
	    System.out.println("Session is open");
	}

	session.beginTransaction();
    }

    public static void sessionCommit() {
	session.getTransaction().commit();
    }

    public static Session getSession() {
	return session;
    }

}

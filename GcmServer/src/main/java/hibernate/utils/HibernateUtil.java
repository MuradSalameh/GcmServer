package main.java.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.java.hibernate.model.Expense;
import main.java.hibernate.model.ExpenseType;
import main.java.hibernate.model.Game;
import main.java.hibernate.model.Genre;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.Revenue;
import main.java.hibernate.model.RevenueType;
import main.java.hibernate.model.Role;
import main.java.hibernate.model.Social;
import main.java.hibernate.model.Team;
import main.java.hibernate.model.Tournament;

public class HibernateUtil {
	private static Session session = null;	
	
	public static void startSession() {
		// create configurations
		Configuration configuration = new Configuration();
		configuration.configure("/main/resources/hibernate.cfg.xml");		
		

		// crate session factory - data source
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//initialize session object
		session = sessionFactory.openSession();

		if(!session.isOpen()) {
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



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


public class SessionUtil {

	private static SessionUtil instance=new SessionUtil();
	private SessionFactory sessionFactory;

	public static SessionUtil getInstance(){
		return instance;
	}

	private SessionUtil(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession(){
		Session session =  getInstance().sessionFactory.openSession();

		return session;
	}

}

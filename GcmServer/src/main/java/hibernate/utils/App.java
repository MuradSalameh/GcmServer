package main.java.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import main.java.hibernate.model.GcmUser;
import main.java.hibernate.model.Role;
import main.java.hibernate.model.Social;

public class App {

	public static void main(String[] args) {

		// create configurations
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(GcmUser.class);
		configuration.addAnnotatedClass(Role.class);
		configuration.addAnnotatedClass(Social.class);

		// crate session factory - datasource
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		//initialize session object
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		// test saveGcmUser()
		GcmUser ulrich = new GcmUser(
				"Ulrich", 
				"Pan", 
				"Strasse XYZ", 
				"33", 
				"84028", 
				"Stadt", 
				"Austria", null, null, null, null);




		//session.save(ulrich);
		session.persist(ulrich);

		Role admin = new Role("admin", "Clan Administrator");
		session.persist(admin);

		Role member = new Role("member", "Clan Member");
		session.persist(member);

		ulrich.getRoles().add(member);
		ulrich.getRoles().add(admin);
		
		session.persist(ulrich);


		GcmUser pauli = new GcmUser(
				"Pauli", 
				"Baum", 
				"Strassenname", 
				"45", 
				"13244", 
				"Town", 
				"Austria", null, null, null, null);		

		session.persist(pauli);

		session.getTransaction().commit();




	}
}

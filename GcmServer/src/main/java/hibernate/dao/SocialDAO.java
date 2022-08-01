package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Social;
import main.java.hibernate.utils.SessionUtil;

public class SocialDAO {
	

	public static void addSocial(Social bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add social nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<Social> getSocials(){
		Session session = SessionUtil.getSession();  
		String hql = "from Social";
		Query query = session.createQuery(hql);
		List<Social> socials =  query.list();		
		session.close();		
		return socials;
	}

	public static void deleteSocial(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Social social = session.find(Social.class, id);
		session.remove(social);
		tx.commit();
		session.close();
		
	}

	public static void updateSocial(int id, Social social){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Social old = session.find(Social.class, id);
		
		old.setSocialPlatform(social.getSocialPlatform());
		old.setSocialUsername(social.getSocialUsername());
		old.setSocialLink(social.getSocialLink());
		old.setSocialNotes(social.getSocialNotes());
			
		tx.commit();
		session.close();		
	}


}

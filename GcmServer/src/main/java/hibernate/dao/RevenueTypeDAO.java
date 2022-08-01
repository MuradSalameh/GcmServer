package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.RevenueType;
import main.java.hibernate.utils.SessionUtil;

public class RevenueTypeDAO {
	

	public static void addRevenueType(RevenueType bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add revenueType nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<RevenueType> getRevenueTypes(){
		Session session = SessionUtil.getSession();  
		String hql = "from RevenueType";
		Query query = session.createQuery(hql);
		List<RevenueType> revenueTypes =  query.list();		
		session.close();		
		return revenueTypes;
	}

	public static void deleteRevenueType(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		RevenueType revenueType = session.find(RevenueType.class, id);
		session.remove(revenueType);
		tx.commit();
		session.close();
		
	}

	public static void updateRevenueType(int id, RevenueType revenueType){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		RevenueType old = session.find(RevenueType.class, id);
		
		old.setRevenueTypeTitle(revenueType.getRevenueTypeTitle());
		old.setRevenueTypeDescription(revenueType.getRevenueTypeDescription());
		old.setRevenues(revenueType.getRevenues());
		
		tx.commit();
		session.close();		
	}


}

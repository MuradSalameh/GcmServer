package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import jakarta.persistence.criteria.CriteriaQuery;
import main.java.hibernate.model.GcmUser;
import main.java.hibernate.utils.HibernateUtil;

public class GcmUserDao {
	// https://www.youtube.com/watch?v=Y0EMDM_Gk3s
	//saveGcmUser
	//getAllGcmUsers
	//getGcmUserById
	//updateGcmUser
	//deleteGcmUser


	public void saveGcmUser(GcmUser gcmuser) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();

			//save gcmuser object
			session.persist(gcmuser);

			//commit transaction
			transaction.commit();

		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void updateGcmUser(GcmUser gcmuser) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();

			//save gcmuser object
			session.persist(gcmuser);

			//commit transaction
			transaction.commit();

		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}

	public GcmUser getGcmUserById(long id) {
		Transaction transaction = null;
		GcmUser gcmUser = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();

			//get gcmUser object
			gcmUser = session.get(GcmUser.class, id);
			//gcmUser = session.load(GcmUser.class, id);
			

			//commit transaction
			transaction.commit();

		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return gcmUser;
	}
	
	
	public List<GcmUser> getAllGcmUsers() {
		Transaction transaction = null;
		List<GcmUser> gcmUsers = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//get gcmUsers
			//gcmUsers = session.createQuery("from Student").list();
			
			CriteriaQuery cq = session.getCriteriaBuilder().createQuery(GcmUser.class);
			cq.from(GcmUser.class);
			gcmUsers = session.createQuery(cq).getResultList();
			
			
			
			//commit transaction
			transaction.commit();
			
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return gcmUsers;
	}
	
	
	public void deleteGcmUser(int id) {
		Transaction transaction = null;
		GcmUser gcmUser = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			gcmUser = session.get(GcmUser.class,id);
			session.remove(gcmUser);
			
			//commit transaction
			transaction.commit();
			
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
}

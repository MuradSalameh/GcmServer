package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import gcmClasses.Event;
import main.java.hibernate.utils.SessionUtil;

public class EventDAO {

	public static void addEvent(Event bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add event nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<Event> getEvents(){
		Session session = SessionUtil.getSession();  
		String hql = "from Event";
		Query query = session.createQuery(hql);
		List<Event> events =  query.list();		
		session.close();		
		return events;
	}

	public static void deleteEvent(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Event event = session.find(Event.class, id);
		session.remove(event);
		tx.commit();
		session.close();
		
	}

	public static void updateEvent(int id, Event event){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Event old = session.find(Event.class, id);
		
		old.setEventTitle(event.getEventTitle());
		old.setEventDescription(event.getEventDescription());
		old.setDate(event.getDate());
		old.setEventStartTime(event.getEventEndTime());
		old.setEventEndTime(event.getEventEndTime());
		old.setEventAddidtionalNotes(event.getEventAddidtionalNotes());
		old.setReoccuring(event.isReoccuring());
		old.setMembers(event.getMembers());		
		
		tx.commit();
		session.close();		
	}


}

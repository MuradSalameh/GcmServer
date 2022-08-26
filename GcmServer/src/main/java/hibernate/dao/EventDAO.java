package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Event;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberEvents;
import main.java.hibernate.utils.SessionUtil;

public class EventDAO {
    
    // database access methods


    // add new event
	public static void addEvent(Event bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(bean); 
		tx.commit();
		session.close();
	}

	
	// get event
	public static Event getEvent(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Event event = session.get(Event.class, id);

		return event;
	}

	
	// get events by member id from MemberEvents table
	public static List<Event> getEventsByMemberId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from MemberEvents event_id where member_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberEvents> eventsMember = query.list();
		List<Event> filteredEventsList = new ArrayList<>();

		for (MemberEvents m : eventsMember) {
			int sId = m.getEvent().getId();
			Event s = session.get(Event.class, sId);
			filteredEventsList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredEventsList;
	}

	
	// get members by event id from MemberEvents table
	public static List<Member> getMembersByEventId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from MemberEvents member_id where event_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberEvents> membersEvent = query.list();
		List<Member> filteredEventsList = new ArrayList<>();

		for (MemberEvents m : membersEvent) {
			int sId = m.getMember().getId();
			Member s = session.get(Member.class, sId);
			filteredEventsList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredEventsList;
	}

	
	// get list of all events
	public static List<Event> getEvents() {
		Session session = SessionUtil.getSession();
		String hql = "from Event";
		Query<Event> query = session.createQuery(hql);
		List<Event> events = query.list();
		session.close();
		return events;
	}

	
	// delete event from all members in MemberEvents table
	public static void deleteEventFromMember(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from MemberEvents id where event_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete event
	public static void deleteEvent(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Event event = session.get(Event.class, id);
		session.remove(event);
		tx.commit();
		session.close();

	}

	
	// update event
	public static void updateEvent(int id, Event event) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Event old = session.get(Event.class, id);

		old.setEventTitle(event.getEventTitle());
		old.setEventDescription(event.getEventDescription());
		old.setDate(event.getDate());
		old.setEventStartTime(event.getEventStartTime());
		old.setEventEndTime(event.getEventEndTime());
		old.setEventAddidtionalNotes(event.getEventAddidtionalNotes());
		old.setReoccuring(event.isReoccuring());

		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}

}

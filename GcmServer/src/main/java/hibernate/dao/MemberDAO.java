package main.java.hibernate.dao;

import main.java.hibernate.model.Member;
import main.java.hibernate.utils.SessionUtil;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class MemberDAO {

	public static void addMember(Member bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add member nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<Member> getMembers(){
		Session session = SessionUtil.getSession();  
		String hql = "from Member";
		Query query = session.createQuery(hql);
		List<Member> members =  query.list();		
		session.close();		
		return members;
	}

	public static void deleteMember(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Member member = session.find(Member.class, id);
		session.remove(member);
		//session.delete(session.find(Member.class, id));
		tx.commit();
		session.close();
		
	}
	
	/*
	public static void updateMember(int id, Member member){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Member old = session.find(Member.class, id);
		
		old.setClanName(member.getClanName());
		old.setClanId(member.getClanId());
		old.setRealName(member.getRealName());
		old.setAddress(member.getAddress());
		old.setAddressPostCode(member.getAddressPostCode());
		old.setAddressCity(member.getAddressCity());
		old.setCountry(member.getCountry());
		old.setEmail(member.getEmail());
		old.setPhoneNumber(member.getPhoneNumber());
		
		old.setRoles(member.getRoles());
		old.setSocials(member.getSocials());
		old.setGames(member.getGames());
		old.setEvents(member.getEvents());
		old.setTeams(member.getTeams());
		
		old.setBirthday(member.getBirthday());		
		
		tx.commit();
		session.close();		
	}
	*/
	
	public static void updateMember(int id, Member member){
		
	
		
        Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Member old = session.find(Member.class, id);
		
		
		
		old.setClanName(member.getClanName());
		old.setClanId(member.getClanId());
		old.setRealName(member.getRealName());
		old.setAddress(member.getAddress());
		old.setAddressPostCode(member.getAddressPostCode());
		old.setAddressCity(member.getAddressCity());
		old.setCountry(member.getCountry());
		old.setEmail(member.getEmail());
		old.setPhoneNumber(member.getPhoneNumber());
		
		old.setRoles(member.getRoles());
		old.setSocials(member.getSocials());
		old.setGames(member.getGames());
		old.setEvents(member.getEvents());
		old.setTeams(member.getTeams());
		
		old.setBirthday(member.getBirthday());		
		
		tx.commit();
		session.close();	
		}
	
	
}

package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Member;
import main.java.hibernate.model.Team;
import main.java.hibernate.utils.SessionUtil;

public class TeamDAO {	

	public static void addTeam(Team bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add team nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}

	public static Team getTeam(int id) {
		   Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
		
			Team t = session.get(Team.class, id);
			
			return t;
	}
	
	public static List<Team> getTeams(){
		Session session = SessionUtil.getSession();  
		String hql = "from Team";
		Query query = session.createQuery(hql);
		List<Team> teams =  new ArrayList<Team>(query.list());	
		session.close();		
		return teams;
	}

	public static void deleteTeam(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Team team = session.find(Team.class, id);
		session.remove(team);
		tx.commit();
		session.close();
		
	}

	public static void updateTeam(int id, Team team){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Team old = session.find(Team.class, id);
		
		old.setTeamName(team.getTeamName());
		old.setTeamDescription(team.getTeamDescription());
		//old.setMembers(team.getMembers());			
		
		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();	
	}


}

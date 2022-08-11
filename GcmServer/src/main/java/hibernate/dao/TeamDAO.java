package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberTeam;
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
	
	
	public static List<Team> getTeamsByMemberId(int id){		
		//SQL: SELECT * FROM gcm.member_teams where member_id= '3'

		Session session = SessionUtil.getSession(); 			
		String hql = "from MemberTeam team_id where member_id= :id";		
		Query query = session.createQuery(hql);
        query.setParameter("id", id);
		List<MemberTeam> teamsMember =  query.list();	
		List<Team> filteredTeamsList =  new ArrayList<>();	
		
		for(MemberTeam m : teamsMember) {
			int sId = m.getTeam().getId();
			Team s = session.get(Team.class, sId);
			filteredTeamsList.add(s);
			System.out.println(s);
		}
						
		session.close();		
		return filteredTeamsList;		
	}
	
	
	public static List<Member> getMembersByTeamId(int id){		
		//SQL: SELECT * FROM gcm.member_teams where member_id= '3'

		Session session = SessionUtil.getSession(); 			
		String hql = "from MemberTeam member_id where team_id= :id";		
		Query query = session.createQuery(hql);
        query.setParameter("id", id);
		List<MemberTeam> membersTeam =  query.list();	
		List<Member> filteredTeamsList =  new ArrayList<>();	
		
		for(MemberTeam m : membersTeam) {
			int sId = m.getMember().getId();
			Member s = session.get(Member.class, sId);
			filteredTeamsList.add(s);
			System.out.println(s);
		}
						
		session.close();		
		return filteredTeamsList;		
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

package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberTeam;
import main.java.hibernate.model.Team;
import main.java.hibernate.model.Tournament;
import main.java.hibernate.model.TournamentsTeams;
import main.java.hibernate.utils.SessionUtil;

public class TeamDAO {
    
    // database access methods
    

    	// add team to db
	public static void addTeam(Team bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(bean);
		tx.commit();
		session.close();
	}

	
	// assign team to tournament in TournamentsTeams table
	public static void addTeamToTournament(int teamID, int tournamentID) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Tournament m = session.get(Tournament.class, tournamentID);
		Team g = session.get(Team.class, teamID);

		TournamentsTeams mr = new TournamentsTeams();
		mr.setTournament(m);
		mr.setTeam(g);

		session.save(mr);
		tx.commit();
		session.close();
	}

	
	// get team from db
	public static Team getTeam(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Team t = session.get(Team.class, id);

		return t;
		
		
	}

	
	// get list of all teams from db
	public static List<Team> getTeams() {
		Session session = SessionUtil.getSession();
		String hql = "from Team";
		Query query = session.createQuery(hql);
		List<Team> teams = new ArrayList<Team>(query.list());
		session.close();
		return teams;
	}

	
	// get teams by member id from MemberTeam table
	public static List<Team> getTeamsByMemberId(int id) {
		// SQL: SELECT * FROM gcm.member_teams where member_id= '3'

		Session session = SessionUtil.getSession();
		String hql = "from MemberTeam team_id where member_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberTeam> teamsMember = query.list();
		List<Team> filteredTeamsList = new ArrayList<>();

		for (MemberTeam m : teamsMember) {
			int sId = m.getTeam().getId();
			Team s = session.get(Team.class, sId);
			filteredTeamsList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredTeamsList;
	}

	
	// get teams by tournament from TournamentsTeams table
	public static List<Team> getTeamsByTournamentId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from TournamentsTeams team_id where tournament_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TournamentsTeams> teamsTournament = query.list();
		List<Team> filteredTeamsList = new ArrayList<>();

		for (TournamentsTeams m : teamsTournament) {
			int sId = m.getTeam().getId();
			Team s = session.get(Team.class, sId);
			filteredTeamsList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredTeamsList;
	}

	
	// get members by team id from MemberTeams table
	public static List<Member> getMembersByTeamId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from MemberTeam member_id where team_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberTeam> membersTeam = query.list();
		List<Member> filteredTeamsList = new ArrayList<>();

		for (MemberTeam m : membersTeam) {
			int sId = m.getMember().getId();
			Member s = session.get(Member.class, sId);
			filteredTeamsList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredTeamsList;
	}

	
	// delete team from all members in MemberTeams table
	public static void deleteTeamFromMember(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		// Delete connection from MemberTeams Table
		String hql = "delete from MemberTeam id where team_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		// Remove from Team Table
//    	Team team = session.get(Team.class, id);
//		session.remove(team);

		tx.commit();
		session.clear();
		session.close();
	}

	// delete team from all tournaments in TournamentsTeams table
	public static void deleteTeamFromTournaments(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		// Delete connection from MemberTeams Table
		String hql = "delete from TournamentsTeams id where team_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete team from specific tournament in TournamentsTeams table
	public static void deleteTeamFromTournament(int teamid, int tournamentid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from TournamentsTeams id where team_id= :teamid and tournament_id= :tournamentid";
		Query query = session.createQuery(hql);
		query.setParameter("teamid", teamid);
		query.setParameter("tournamentid", tournamentid);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete team
	public static void deleteTeam(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Team team = session.get(Team.class, id);
		session.remove(team);
		tx.commit();
		session.close();

	}

	// update team
	public static void updateTeam(int id, Team team) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Team old = session.get(Team.class, id);

		old.setTeamName(team.getTeamName());
		old.setTeamDescription(team.getTeamDescription());
		// old.setMembers(team.getMembers());

		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}

}

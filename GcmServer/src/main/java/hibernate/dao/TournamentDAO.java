package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Tournament;
import main.java.hibernate.utils.SessionUtil;

public class TournamentDAO {

	public static void addTournament(Tournament bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add tournament nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}


	public static List<Tournament> getTournaments(){
		Session session = SessionUtil.getSession();  
		String hql = "from Tournament";
		Query query = session.createQuery(hql);
		List<Tournament> tournaments =  query.list();		
		session.close();		
		return tournaments;
	}

	public static void deleteTournament(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Tournament tournament = session.find(Tournament.class, id);
		session.remove(tournament);
		tx.commit();
		session.close();
		
	}

	public static void updateTournament(int id, Tournament tournament){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Tournament old = session.find(Tournament.class, id);
		
		old.setTouramentTitle(tournament.getTouramentTitle());
		old.setTournamentDescription(tournament.getTournamentDescription());
		old.setTournamentDate(tournament.getTournamentDate());
		old.setTournamentTimeBeginn(tournament.getTournamentTimeBeginn());
		old.setTournamentTimeEnd(tournament.getTournamentTimeEnd());
		old.setTeams(tournament.getTeams());
		//old.setGame(tournament.getGame());
		old.setTournamentResult(tournament.getTournamentResult());
		
		tx.commit();
		session.close();		
	}


}

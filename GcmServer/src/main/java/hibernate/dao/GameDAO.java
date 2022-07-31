package main.java.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Game;
import main.java.hibernate.utils.SessionUtil;

public class GameDAO {
	
	public static void addGame(Game bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add game nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}

	public static List<Game> getGames(){
		Session session = SessionUtil.getSession();  
		String hql = "from Game";
		Query query = session.createQuery(hql);
		List<Game> games =  query.list();		
		session.close();		
		return games;
	}

	public static void deleteGame(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game game = session.find(Game.class, id);
		session.remove(game);
		tx.commit();
		session.close();
		
	}

	public static void updateGame(int id, Game game){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game old = session.find(Game.class, id);
		
		old.setGameTitle(game.getGameTitle());
		old.setReleaseDate(game.getReleaseDate());
		old.setGenres(game.getGenres());
		old.setMembers(game.getMembers());
		old.setTournaments(game.getTournaments());
		old.setGameAdditionalNotes(game.getGameAdditionalNotes());
		
		tx.commit();
		session.close();		
	}


}

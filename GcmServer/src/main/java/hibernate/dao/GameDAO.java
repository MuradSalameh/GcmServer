package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Game;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberGames;
import main.java.hibernate.utils.SessionUtil;

public class GameDAO {
	
	public static void addGame(Game bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();		
		 
		session.persist(bean);    // Dafür die add game nicht mehr aufrufen, da direkt im bean gespeichert wird.
		tx.commit();
		session.close();
	}
	
	public static Game getGame(int id) {
		   Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
		
			Game game = session.get(Game.class, id);
			
			return game;
	}

	public static List<Game> getGames(){
		Session session = SessionUtil.getSession();  
		String hql = "from Game";
		Query query = session.createQuery(hql);
		List<Game> games =  query.list();		
		session.close();		
		return games;
	}
	
	
	//---------------------------------------------
	public static List<Game> getGamesByMemberId(int id){		
		//SQL: SELECT * FROM gcm.member_games where member_id= '3'

		Session session = SessionUtil.getSession(); 			
		String hql = "from MemberGames game_id where member_id= :id";		
		Query query = session.createQuery(hql);
        query.setParameter("id", id);
		List<MemberGames> gamesMember =  query.list();	
		List<Game> filteredGamesList =  new ArrayList<>();	
		
		for(MemberGames m : gamesMember) {
			int sId = m.getGame().getId();
			Game s = session.get(Game.class, sId);
			filteredGamesList.add(s);
			System.out.println(s);
		}
						
		session.close();		
		return filteredGamesList;		
	}
	
	
	public static List<Member> getMembersByGameId(int id){		
		//SQL: SELECT * FROM gcm.member_games where member_id= '3'

		Session session = SessionUtil.getSession(); 			
		String hql = "from MemberGames member_id where game_id= :id";		
		Query query = session.createQuery(hql);
        query.setParameter("id", id);
		List<MemberGames> membersGame =  query.list();	
		List<Member> filteredGamesList =  new ArrayList<>();	
		
		for(MemberGames m : membersGame) {
			int sId = m.getMember().getId();
			Member s = session.get(Member.class, sId);
			filteredGamesList.add(s);
			System.out.println(s);
		}
						
		session.close();		
		return filteredGamesList;		
	}
	//---------------------------------------------

	public static void deleteGame(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game game = session.get(Game.class, id);
		session.remove(game);
		tx.commit();
		session.close();
		
	}

	public static void updateGame(int id, Game game){
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game old = session.get(Game.class, id);
		
		old.setGameTitle(game.getGameTitle());
		old.setReleaseDate(game.getReleaseDate());
		//old.setGenres(game.getGenres());
		//old.setMembers(game.getMembers());
		//old.setTournaments(game.getTournaments());
		old.setGameAdditionalNotes(game.getGameAdditionalNotes());
		
		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();	
	}


}

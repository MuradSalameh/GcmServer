package main.java.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.hibernate.model.Game;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberGames;
import main.java.hibernate.model.Tournament;
import main.java.hibernate.model.TournamentGame;
import main.java.hibernate.utils.SessionUtil;

public class GameDAO {

    // database access methods
    
    	// add new game
	public static void addGame(Game bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		session.persist(bean); 
		tx.commit();
		session.close();
	}

	
	// assign game to member in MemberGames table
	public static void addGameToMember(int memberID, int gameID) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Member m = session.get(Member.class, memberID);
		Game g = session.get(Game.class, gameID);

		MemberGames mr = new MemberGames();
		mr.setMember(m);
		mr.setGame(g);

		session.save(mr);
		tx.commit();
		session.close();
	}

	
	// assign game to tournament in TournamentGame table
	public static void addGameToTournament(int gameID, int tournamentID) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Tournament m = session.get(Tournament.class, tournamentID);
		Game g = session.get(Game.class, gameID);

		TournamentGame mr = new TournamentGame();
		mr.setTournament(m);
		mr.setGame(g);

		session.save(mr);
		tx.commit();
		session.close();
	}

	
	// get game
	public static Game getGame(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Game game = session.get(Game.class, id);

		return game;
	}

	
	//get list of all games
	public static List<Game> getGames() {
		Session session = SessionUtil.getSession();
		String hql = "from Game";
		Query query = session.createQuery(hql);
		List<Game> games = query.list();
		session.close();
		return games;
	}

	
	// get games by member id from MemberGames table
	public static List<Game> getGamesByMemberId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from MemberGames game_id where member_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberGames> gamesMember = query.list();
		List<Game> filteredGamesList = new ArrayList<>();

		for (MemberGames m : gamesMember) {
			int sId = m.getGame().getId();
			Game s = session.get(Game.class, sId);
			filteredGamesList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredGamesList;
	}

	
	// get games by tournament id from TournamentGame table
	public static List<Game> getGamesByTournamentId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from TournamentGame game_id where tournament_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TournamentGame> gamesTournament = query.list();
		List<Game> filteredGamesList = new ArrayList<>();

		for (TournamentGame m : gamesTournament) {
			int sId = m.getGame().getId();
			Game s = session.get(Game.class, sId);
			filteredGamesList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredGamesList;
	}

	
	// get Members by game id from MemberGames table
	public static List<Member> getMembersByGameId(int id) {

		Session session = SessionUtil.getSession();
		String hql = "from MemberGames member_id where game_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<MemberGames> membersGame = query.list();
		List<Member> filteredGamesList = new ArrayList<>();

		for (MemberGames m : membersGame) {
			int sId = m.getMember().getId();
			Member s = session.get(Member.class, sId);
			filteredGamesList.add(s);
			System.out.println(s);
		}

		session.close();
		return filteredGamesList;
	}
	

	// delete game from secific member in MemberGames table
	public static void deleteGameFromMember(int gameid, int memberid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from MemberGames id where game_id= :gameid and member_id= :memberid";
		Query query = session.createQuery(hql);
		query.setParameter("gameid", gameid);
		query.setParameter("memberid", memberid);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");

		// Remove from Game Table
		// Game game = session.get(Game.class, id);
		// session.remove(game);

		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete game from all members in MemberGame table
	public static void deleteGameFromAllMembers(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from MemberGames id where game_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");



		tx.commit();
		session.clear();
		session.close();
	}

	// delete game from all tournaments in TournamentGame table
	public static void deleteGameFromAllTournaments(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from TournamentGame id where game_id= :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");


		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete game from specific tournament in TournamentGame table
	public static void deleteGameFromTournament(int gameid, int tournamentid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete from TournamentGame id where game_id= :gameid and tournament_id= :tournamentid";
		Query query = session.createQuery(hql);
		query.setParameter("gameid", gameid);
		query.setParameter("tournamentid", tournamentid);

		int count = query.executeUpdate();
		System.out.println(count + " Record(s) Deleted.");


		tx.commit();
		session.clear();
		session.close();
	}

	
	// delete game
	public static void deleteGame(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game game = session.get(Game.class, id);
		session.remove(game);
		tx.commit();
		session.close();

	}

	
	// update game
	public static void updateGame(int id, Game game) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Game old = session.get(Game.class, id);

		old.setGameTitle(game.getGameTitle());
		old.setReleaseDate(game.getReleaseDate());

		old.setGameAdditionalNotes(game.getGameAdditionalNotes());

		session.saveOrUpdate(old);
		session.flush();
		tx.commit();
		session.close();
	}

}

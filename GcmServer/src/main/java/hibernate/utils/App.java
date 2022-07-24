package main.java.hibernate.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import main.java.hibernate.model.Game;
import main.java.hibernate.model.Genre;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.Role;
import main.java.hibernate.model.Social;
import main.java.hibernate.model.Team;
import main.java.hibernate.model.Tournament;

public class App {

	public static void main(String[] args) {

		HibernateUtil.startSession();

		// test persist GcmUser
		Member ulli = new Member(
				"Ulli", 					// first name
				"Bulli", 					// last name
				"Street 1", 				// street
				"44", 						// street number
				"1160", 					// post code
				"Vienna", 					// city
				"Austria", 					// country
				"ulli@email.com", 			// mail
				"+43 677 678 643 44", 		// phone number
				null, 						// role
				null, 						// socials
				null, 						// games
				LocalDate.of(1981, 4, 11), 	// birthday
				null);						// teams

		HibernateUtil.getSession().persist(ulli);

		Member hans = new Member(
				"hans", 					// first name
				"kranz", 					// last name
				"Street2", 					// street
				"333", 						// street number
				"14129", 					// post code
				"Berlin", 					// city
				"Germany", 					// country
				"hans@email.com", 			// mail
				"+49 177 456 543 11", 		// phone number
				null, 						// role
				null, 						// socials
				null, 						// games
				null, 						// birthday
				null);						// teams

		hans.setBirthday(LocalDate.of(1990, 8, 30));
		HibernateUtil.getSession().persist(hans);


		// test roles join table

		Role admin = new Role("admin", "Clan Administrator");
		//session.persist(admin);

		Role member = new Role("member", "Clan Member");
		//session.persist(member);

		List<Role> roles = new ArrayList<Role>();
		roles.add(admin);
		roles.add(member);	

		ulli.setRoles(roles);
		HibernateUtil.getSession().persist(ulli);


		// test socials join table

		Social social1 = new Social("YouTube", "Ulli", "www.youtube.com","neuer gaming kanal");
		Social social2 = new Social("Facebook", "UlliFB", "www.facebook.com","FB-Seite");		

		List<Social> socials = new ArrayList<Social>();
		socials.add(social1);
		socials.add(social2);

		ulli.setSocials(socials);	
		HibernateUtil.getSession().persist(ulli);


		//////// test tournament - teams join table
		//create team 1
		Team t1 = new Team(
				"team #1", 		// team name
				"test team #1", // team description
				null);			// team members list

		// create member list for team
		List<Member> membersTeam1 = new ArrayList<Member>();

		// create team 2
		Team t2 = new Team(
				"team #2", 		// team name
				"test team #2", // team description
				null);			// team members	list	

		// create member list for team 2
		List<Member> membersTeam2 = new ArrayList<Member>();

		// add members to member lists
		membersTeam1.add(ulli);
		t1.setMembers(membersTeam1);
		HibernateUtil.getSession().persist(t1);

		membersTeam2.add(hans);
		t1.setMembers(membersTeam1);
		HibernateUtil.getSession().persist(t2);

		// Add teams to a list
		List<Team> teams = new ArrayList<Team>();
		teams.add(t1);
		teams.add(t2);



		//create basic tournament
		Tournament tournament1 = new Tournament(
				"TestTournament #1", 		//title
				"Testing nr 1", 			// description
				LocalDate.of(1990, 8, 30),	// tournament date
				LocalTime.of(22,58),		// start time
				LocalTime.of(2,30), 		// end time
				null,						// teams list
				null,						// games list
				null);						// result string

		// Create Game
		Game game1 = new Game(
				"TestGame #1", 						// title
				LocalDate.of(2022, 10, 28), 						// release date LocalDate
				null, 						// genre list
				null, 						// member list
				null, 						// tournament list
				null);						// additional notes

		// Create games list and add created games
		List<Game> games = new ArrayList<Game>();
		games.add(game1);		

		// Create genres
		Genre strategy = new Genre("strategy", null);
		Genre simulation = new Genre("simulation", null);	

		// Add genres to list
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(strategy);
		genres.add(simulation);	

		// persist game together with new genre list
		game1.setGenres(genres);
		HibernateUtil.getSession().persist(game1);

		// persist tournament together with teams list		
		tournament1.setTeams(teams);
		HibernateUtil.getSession().persist(tournament1);
		
		// Set Games to members
		hans.setGames(games);
		HibernateUtil.getSession().persist(hans);
		
		ulli.setGames(games);
		HibernateUtil.getSession().persist(ulli);
		
		//set game to tournament
		tournament1.setGame(game1);


		HibernateUtil.sessionCommit();
	}
}



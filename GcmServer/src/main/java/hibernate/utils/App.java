package main.java.hibernate.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				"Ulli", 					// clan name
				"Bulli", 					// clan id
				"Street 1", 				// real name
				"44", 						// address
				"1160", 					// post code
				"Vienna", 					// city
				"Austria", 					// country
				"ulli@email.com", 			// mail
				"+43 677 678 643 44", 		// phone number
				null, 						// roles
				null, 						// socials
				null, 						// games
				null,						// events
				LocalDate.of(1981, 4, 11), 	// birthday
				null);						// teams

		HibernateUtil.getSession().persist(ulli);
		

		Member hans = new Member(
				"hans", 					// clan name
				"kranz", 					// clan id
				"Street2", 					// real name
				"333", 						// address
				"14129", 					// post code
				"Berlin", 					// city
				"Germany", 					// country
				"hans@email.com", 			// mail
				"+49 177 456 543 11", 		// phone number
				null, 						// roles
				null, 						// socials
				null, 						// games
				null,						// events
				null, 						// birthday
				null);						// teams

		hans.setBirthday(LocalDate.of(1990, 8, 30));
		HibernateUtil.getSession().persist(hans);
		


// test roles join table

		Role adminRole = new Role("admin", "Clan Administrator");
		HibernateUtil.getSession().persist(adminRole);

		Role memberRole = new Role("member", "Clan Member");
		HibernateUtil.getSession().persist(memberRole);

		List<Role> roles = new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(memberRole);	

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


// test teams join table
		
		//create team 1
		Team t1 = new Team(
				"team #1", 		// team name
				"test team #1", // team description
				null);			// team members list
		
		
		HibernateUtil.getSession().persist(t1);
		
		// create member list for team
		Set<Member> membersTeam1 = new HashSet<>();
		membersTeam1.add(ulli);
		t1.setMembers(membersTeam1);
		HibernateUtil.getSession().persist(t1);
		
		// create team 2
		Team t2 = new Team(
				"team #2", 		// team name
				"test team #2", // team description
				null);			// team members	list	
		


		// create member list for team 2
		Set<Member> membersTeam2 = new HashSet<Member>();
		membersTeam2.add(hans);
		t2.setMembers(membersTeam2);		
		HibernateUtil.getSession().persist(t2);

		// Add teams to a list
		Set<Team> teams = new HashSet<Team>();
		teams.add(t1);
		teams.add(t2);
		

// test tournament
		Tournament tournament1 = new Tournament(
				"TestTournament #1", 		//title
				"Testing nr 1", 			// description
				LocalDate.of(1990, 8, 30),	// tournament date
				LocalTime.of(22,58),		// start time
				LocalTime.of(2,30), 		// end time
				null,						// teams list
				null,						// games list
				null);						// result string

// test Game
		Game game1 = new Game(
				"TestGame #1", 				// title
				LocalDate.of(2022, 10, 28), // release date LocalDate
				null, 						// genre list
				null, 						// member list
				null, 						// tournament list
				null);						// additional notes

		// Create games list and add created games
		Set<Game> games = new HashSet<Game>();
		games.add(game1);	
		
		
		// Create tournaments list and add created tournaments to list
		List<Tournament> tournaments = new ArrayList<Tournament>();
		tournaments.add(tournament1);			

// test Create genres
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

// test games to members
		hans.setGames(games);
		HibernateUtil.getSession().persist(hans);

		ulli.setGames(games);
		HibernateUtil.getSession().persist(ulli);

// test tournament to game
		game1.setTournaments(tournaments);

		


		HibernateUtil.sessionCommit();
	}
}



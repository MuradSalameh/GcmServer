package main.java.hibernate.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.Role;
import main.java.hibernate.model.Social;

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
		//session.persist(social1);

		Social social2 = new Social("Facebook", "UlliFB", "www.facebook.com","FB-Seite");
		//session.persist(social2);

		List<Social> socials = new ArrayList<Social>();
		socials.add(social1);
		socials.add(social2);

		ulli.setSocials(socials);	
		HibernateUtil.getSession().persist(ulli);


		//////// test tournament - teams join table


		/*
		//create teams
		Team t1 = new Team(
				"team #1", 		// team name
				"test team #1", // team description
				null);			// team members list

		List<Member> membersTeam1 = new ArrayList<Member>();

		Team t2 = new Team(
				"team #2", 		// team name
				"test team #2", // team description
				null);			// team members	list	

		List<Member> membersTeam2 = new ArrayList<Member>();

		// add members to teams
		membersTeam1.add(ulli);
		membersTeam2.add(hans);


		// Add teams to a list
		List<Team> teams = new ArrayList<Team>();
		teams.add(t1);
		teams.add(t2);
		

		//create basic tournament
		Tournament tournament1 = new Tournament("Tournament #1", null, null, null, null, null, null, null);
		// add teams to tournament
		tournament1.setTeams(teams);

		
		// Create Game
		Game game1 = new Game("Game#1",null , null, null);
		game1.setReleaseDate(LocalDate.of(2022, 10, 28));
		
		List<Game> games = new ArrayList<Game>();
		games.add(game1);		

		// Create genres
		Genre strategy = new Genre("strategy", null);
		Genre simulation = new Genre("strategy", null);		
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(strategy);
		genres.add(simulation);	

		game1.setGenres(genres);
		HibernateUtil.getSession().persist(game1);
	

		tournament1.setTeams(teams);
*/

		HibernateUtil.sessionCommit();
	}
}



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
import main.java.hibernate.model.MemberGames;
import main.java.hibernate.model.MemberTeam;
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

		// create team 2
		Team t2 = new Team(
				"team #2", 		// team name
				"test team #2", // team description
				null);			// team members	list	

		HibernateUtil.getSession().persist(t2);

		//Teamlist List for tournaments
		Set<Team> teams = new HashSet<Team>();
		teams.add(t1);
		teams.add(t2);


		// Connect members with team
		MemberTeam memberTeam1 = new MemberTeam();
		memberTeam1.setTeam(t1);     //specify Team 

		memberTeam1.setMember(hans);	//add Member to team 
		HibernateUtil.getSession().save(memberTeam1);	// save

		memberTeam1.setMember(ulli);	//add Member to team		
		HibernateUtil.getSession().save(memberTeam1);	//save

		//		Set<Member>memberTeams1 = new HashSet<>();
		//		// Add Team to Member Teams List
		//		memberTeams1.add(ulli);
		//		//Assign List of Teams to Member
		//		t1.setMembers(memberTeams1);
		//
		//		HibernateUtil.getSession().saveOrUpdate(t1);



		/*
		// Create Team List for member
		Set<Team>memberTeams1 = new HashSet<>();
		// Add Team to Member Teams List
		memberTeams1.add(t1);
		//Assign List of Teams to Member
		ulli.setTeams(memberTeams1);

		HibernateUtil.getSession().persist(ulli);




		// create member list for team 2
		// Create Team List for member
		Set<Team>memberTeams2 = new HashSet<>();
		// Add Team to Member Teams List
		memberTeams2.add(t1);
		//Assign List of Teams to Member
		hans.setTeams(memberTeams2);

		 */
		// Add teams to a list



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


		// test Game
		Game game2 = new Game(
				"TestGame 22222222", 				// title
				LocalDate.of(2022, 10, 28), // release date LocalDate
				null, 						// genre list
				null, 						// member list
				null, 						// tournament list
				null);						// additional notes


		// Create games list and add created games
		Set<Game> gameList = new HashSet<Game>();
		gameList.add(game1);	
		gameList.add(game2);	

		// Connect games to members --- ManyToMany custom Class
		// Every New Entry/Row needs its own MembersGames Object
		
		MemberGames memberGames1 = new MemberGames();
		memberGames1.setGame(game1);			
		memberGames1.setMember(ulli);	//add member
		HibernateUtil.getSession().saveOrUpdate(memberGames1);	

		MemberGames memberGames2 = new MemberGames();
		memberGames2.setGame(game2);     //specify game		
		//memberGames2.setGame(game2);     //specify game		
		memberGames2.setMember(ulli);	//add member
		HibernateUtil.getSession().saveOrUpdate(memberGames2);	// s

		MemberGames memberGames3 = new MemberGames();
		memberGames3.setGame(game2);			
		memberGames3.setMember(hans);	//add member
		HibernateUtil.getSession().saveOrUpdate(memberGames3);	








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



		// test tournament to game
		game1.setTournaments(tournaments);




		HibernateUtil.sessionCommit();
	}
}



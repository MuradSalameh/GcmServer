package main.java.hibernate.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import main.java.hibernate.model.Event;
import main.java.hibernate.model.Expense;
import main.java.hibernate.model.Game;
import main.java.hibernate.model.GameGenres;
import main.java.hibernate.model.Genre;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberEvents;
import main.java.hibernate.model.MemberGames;
import main.java.hibernate.model.MemberTeam;
import main.java.hibernate.model.Partner;
import main.java.hibernate.model.Revenue;
import main.java.hibernate.model.Role;
import main.java.hibernate.model.Social;
import main.java.hibernate.model.Team;
import main.java.hibernate.model.Tournament;
import main.java.hibernate.model.TournamentGame;
import main.java.hibernate.model.TournamentsTeams;

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
				null, 		//members teams
				null);			// team tournaments teams

		HibernateUtil.getSession().persist(t1);

		// create team 2
		Team t2 = new Team(
				"team #2", 		// team name
				"test team #2", // team description
				null, 		//members teams
				null);			// team tournaments teams

		HibernateUtil.getSession().persist(t2);

		
		
		
		// Connect members with team
		MemberTeam memberTeam1 = new MemberTeam();
		memberTeam1.setTeam(t1);     //specify Team 

		memberTeam1.setMember(hans);	//add Member to team 
		HibernateUtil.getSession().save(memberTeam1);	// save

		memberTeam1.setMember(ulli);	//add Member to team		
		HibernateUtil.getSession().save(memberTeam1);	//save




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


		// test tournament
		Tournament tournament2 = new Tournament(
				"TestTournament #222222", 	//title
				"Testing nr 2", 			// description
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

		
		// test Create genres
		Genre strategy = new Genre("strategy", null);
		Genre simulation = new Genre("simulation", null);	


		// Connect Games to Genres --- ManyToMany custom Class
		// Every New Entry/Row needs its own Object

		GameGenres gameGenre1 = new GameGenres();
		gameGenre1.setGame(game1);			
		gameGenre1.setGenre(strategy);	//add member
		HibernateUtil.getSession().saveOrUpdate(gameGenre1);	

		GameGenres gameGenre2 = new GameGenres();
		gameGenre2.setGame(game1);     //specify game			
		gameGenre2.setGenre(simulation);	//add member

		HibernateUtil.getSession().saveOrUpdate(gameGenre2);	

		
		

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
		HibernateUtil.getSession().saveOrUpdate(memberGames2);	

		MemberGames memberGames3 = new MemberGames();
		memberGames3.setGame(game2);			
		memberGames3.setMember(hans);	//add member
		HibernateUtil.getSession().saveOrUpdate(memberGames3);	




		// Connect Tournaments to Teams --- ManyToMany custom Class
		// Every New Entry/Row needs its own TournamentsTeams Object

		TournamentsTeams tournamentTeam1 = new TournamentsTeams();
		tournamentTeam1.setTournament(tournament1);			
		tournamentTeam1.setTeam(t1);	//add member
		HibernateUtil.getSession().saveOrUpdate(tournamentTeam1);	

		TournamentsTeams tournamentTeam2 = new TournamentsTeams();
		tournamentTeam2.setTournament(tournament1);     //specify game			
		tournamentTeam2.setTeam(t2);	//add member

		HibernateUtil.getSession().saveOrUpdate(tournamentTeam2);	




		// Connect Tournament to Game --- ManyToMany custom Class
		// Every New Entry/Row needs its own TournamentGame Object

		TournamentGame tournamentGame1 = new TournamentGame();
		tournamentGame1.setTournament(tournament1);			
		tournamentGame1.setGame(game1);	//add member
		HibernateUtil.getSession().saveOrUpdate(tournamentGame1);	

		TournamentGame tournamentGame2 = new TournamentGame();
		tournamentGame2.setTournament(tournament2);     //specify game			
		tournamentGame2.setGame(game2);	//add member

		HibernateUtil.getSession().saveOrUpdate(tournamentGame2);	



		// test tournament to game


		//Create news Event
		Event event1 = new Event(
				"erstes event", 					// event title
				"event descr", 					// eventdescription
				LocalDate.of(1990, 8, 30),	// tournament date
				LocalTime.of(22,58),		// start time
				LocalTime.of(2,30), 		// end time
				"lorem ipsum", 			// additional notes
				false, 						// reoccuring
				null);						// members

		Event event2 = new Event(
				"party event", 					// event title
				"event descr", 					// eventdescription
				LocalDate.of(1990, 8, 30),	// tournament date
				LocalTime.of(22,58),		// start time
				LocalTime.of(2,30), 		// end time
				"lorem ipsum", 			// additional notes
				false, 						// reoccuring
				null);						// members


		// Connect Events to members --- ManyToMany custom Class
		// Every New Entry/Row needs its own Membervents Object

		MemberEvents memberEvents1 = new MemberEvents();
		memberEvents1.setEvent(event1);			
		memberEvents1.setMember(ulli);	//add member
		HibernateUtil.getSession().saveOrUpdate(memberEvents1);	

		MemberEvents memberEvents2 = new MemberEvents();
		memberEvents2.setEvent(event2);     //specify game			
		memberEvents2.setMember(ulli);	//add member

		HibernateUtil.getSession().saveOrUpdate(memberEvents2);	
		
		
		
		Expense e1 = new Expense(
				"test", 					// title
				"ttttt", 					// desc
				500.00, 					// amount
				LocalDate.of(1981, 4, 11),	// date
				"heinrich" 					//recipient
				);	
		HibernateUtil.getSession().persist(e1);
		

		Expense e2 = new Expense(
				"test", 					// title
				"ttttt", 					// desc
				500.00, 					// amount
				LocalDate.of(1981, 4, 11),	// date
				"heinrich" 					//recipient
				);	
		
		HibernateUtil.getSession().persist(e2);
		
		Expense e3 = new Expense(
				"test", 					// title
				"ttttt", 					// desc
				1000.00, 					// amount
				LocalDate.of(1981, 4, 11),	// date
				"heinrich" 					//recipient
				);						
		HibernateUtil.getSession().persist(e3);
		
		Revenue r1 = new Revenue(
				"Revenue", 					// title
				"earnings", 					// desc
				5000, 					// amount
				LocalDate.of(1981, 4, 11));	// date
		
		HibernateUtil.getSession().persist(r1);

			
		Revenue r2 = new Revenue(
				"Revenue", 					// title
				"earnings", 					// desc
				2000, 					// amount
				LocalDate.of(1981, 4, 11));	// date
		
		HibernateUtil.getSession().persist(r2);

		
		Revenue r3 = new Revenue(
				"Revenue", 					// title
				"earnings", 					// desc
				1000, 					// amount
				LocalDate.of(1981, 4, 11));	// date
		
		HibernateUtil.getSession().persist(r3);
		
		
		Partner p1 = new Partner(
				"111111111", 					// company name
				"ttttt", 					// contact person name
				"tttttt 1", 				// contact person phone
				"contact@mail.com", 			// contact person mail
				"dfvdfv", 					// first name
				"rororor", 					// last name
				"StreetCompany", 			// adress street 
				"99", 						// addess number 
				"2345", 					// post code
				"Dublin", 					// city
				"Ireland", 					// country
				"company@company.com", 		// email
				"+43 677 678 643 44" 		// phone
				);						// reveues

		HibernateUtil.getSession().persist(p1);

		Partner p2 = new Partner(
				"22222222222222", 					// company name
				"ttttt", 					// contact person name
				"tttttt 1", 				// contact person phone
				"contact@mail.com", 			// contact person mail
				"dfvdfv", 					// first name
				"rororor", 					// last name
				"StreetCompany", 			// adress street 
				"99", 						// addess number 
				"2345", 					// post code
				"Dublin", 					// city
				"Ireland", 					// country
				"company@company.com", 		// email
				"+43 677 678 643 44" 		// phone
				);						// reveues
		
		HibernateUtil.getSession().persist(p2);
		
		Partner p3 = new Partner(
				"3333333333333", 					// company name
				"ttttt", 					// contact person name
				"tttttt 1", 				// contact person phone
				"contact@mail.com", 			// contact person mail
				"dfvdfv", 					// first name
				"rororor", 					// last name
				"StreetCompany", 			// adress street 
				"99", 						// addess number 
				"2345", 					// post code
				"Dublin", 					// city
				"Ireland", 					// country
				"company@company.com", 		// email
				"+43 677 678 643 44" 		// phone
				);						// reveues
		
		HibernateUtil.getSession().persist(p3);
		



		HibernateUtil.sessionCommit();
	}
}



package main.java.hibernate.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import main.java.hibernate.model.Event;
import main.java.hibernate.model.Expense;
import main.java.hibernate.model.Game;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.MemberEvents;
import main.java.hibernate.model.MemberGames;
import main.java.hibernate.model.MemberRoles;
import main.java.hibernate.model.MemberSocials;
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

		if (HibernateUtil.getSession() != null) {
			HibernateUtil.getSession().close();
		}

		HibernateUtil.startSession();

		// test persist GcmUser
		Member superAdmin = new Member("SuperAdmin", // clan name
				"-", // clan id
				"-", // real name
				"-", // address
				"-", // post code
				"-", // city
				"-", // country
				"-", // mail
				"-", // phone number
				null, // roles
				null, // socials
				null, // games
				null, // events
				LocalDate.of(1981, 4, 11), // birthday
				null); // teams

		HibernateUtil.getSession().persist(superAdmin);

		// test persist GcmUser
		Member ulli = new Member("Ulli", // clan name
				"#345634653456", // clan id
				"Real Ulli", // real name
				"Street 45", // address
				"1160", // post code
				"Vienna", // city
				"Austria", // country
				"ulli@email.com", // mail
				"+43 677 678 643 44", // phone number
				null, // roles
				null, // socials
				null, // games
				null, // events
				LocalDate.of(1981, 4, 11), // birthday
				null); // teams

		HibernateUtil.getSession().persist(ulli);

		Member hans = new Member("hans", // clan name
				"#1234555433", // clan id
				"Real Hans", // real name
				"Street 5677", // address
				"14129", // post code
				"Berlin", // city
				"Germany", // country
				"hans@email.com", // mail
				"+49 177 456 543 11", // phone number
				null, // roles
				null, // socials
				null, // games
				null, // events
				null, // birthday
				null); // teams

		hans.setBirthday(LocalDate.of(1990, 8, 30));
		HibernateUtil.getSession().persist(hans);

		Role admin = new Role("Admin", "Clan Administrator", null);
		HibernateUtil.getSession().persist(admin);

		Role mod = new Role("Mod", "Clan Moderator", null);
		HibernateUtil.getSession().persist(mod);

		Role vip = new Role("VIP", "Clan VIP", null);
		HibernateUtil.getSession().persist(vip);

		Role member = new Role("Member", "Clan Member", null);
		HibernateUtil.getSession().persist(member);

		Role guest = new Role("Guest", "Guest", null);
		HibernateUtil.getSession().persist(guest);

		// Every Role Member Connection needs its own MemberRoles Object!!
		MemberRoles sar1 = new MemberRoles();
		sar1.setMember(superAdmin);
		sar1.setRole(admin);
		HibernateUtil.getSession().save(sar1);

		MemberRoles sar2 = new MemberRoles();
		sar2.setMember(superAdmin);
		sar2.setRole(mod);
		HibernateUtil.getSession().save(sar2);

		MemberRoles sar3 = new MemberRoles();
		sar3.setMember(superAdmin);
		sar3.setRole(vip);
		HibernateUtil.getSession().save(sar3);

		MemberRoles sar4 = new MemberRoles();
		sar4.setMember(superAdmin);
		sar4.setRole(member);
		HibernateUtil.getSession().save(sar4);

		MemberRoles sar5 = new MemberRoles();
		sar5.setMember(superAdmin);
		sar5.setRole(guest);
		HibernateUtil.getSession().save(sar5);

		MemberRoles mr2 = new MemberRoles();
		mr2.setRole(guest);
		mr2.setMember(ulli);
		HibernateUtil.getSession().save(mr2);

		// test socials join table

		Social social1 = new Social("YouTube", "Ulli", "www.youtube.com", "neuer gaming kanal", null);
		HibernateUtil.getSession().persist(social1);

		Social social2 = new Social("Facebook", "UlliFB", "www.facebook.com", "FB-Seite", null);
		HibernateUtil.getSession().persist(social2);
		// Connect socials with member

		MemberSocials ms1 = new MemberSocials();
		ms1.setSocial(social1);
		ms1.setMember(ulli);
		HibernateUtil.getSession().save(ms1);

		MemberSocials ms2 = new MemberSocials();
		ms2.setSocial(social2);
		ms2.setMember(ulli);
		HibernateUtil.getSession().save(ms2);

		// test teams join table

		// create team 1
		Team t1 = new Team("team #1", // team name
				"test team #1", // team description
				null, // members teams
				null); // team tournaments teams

		HibernateUtil.getSession().persist(t1);

		// create team 2
		Team t2 = new Team("team #2", // team name
				"test team #2", // team description
				null, // members teams
				null); // team tournaments teams

		HibernateUtil.getSession().persist(t2);

		// Connect members with team
		MemberTeam memberTeam1 = new MemberTeam();
		memberTeam1.setTeam(t1); // specify Team

		memberTeam1.setMember(hans); // add Member to team
		HibernateUtil.getSession().save(memberTeam1); // save

		memberTeam1.setMember(ulli); // add Member to team
		HibernateUtil.getSession().save(memberTeam1); // save

		// test tournament
		Tournament tournament1 = new Tournament("TestTournament #1", // title
				"Testing nr 1", // description
				LocalDate.of(1990, 8, 30), // tournament date
				LocalTime.of(22, 58), // start time
				LocalTime.of(2, 30), // end time
				null, // teams list
				null, // games list
				null); // result string

		HibernateUtil.getSession().persist(tournament1);

		// test tournament
		Tournament tournament2 = new Tournament("TestTournament #222222", // title
				"Testing nr 2", // description
				LocalDate.of(1990, 8, 30), // tournament date
				LocalTime.of(22, 58), // start time
				LocalTime.of(2, 30), // end time
				null, // teams list
				null, // games list
				null); // result string
		HibernateUtil.getSession().persist(tournament2);

		// test Game
		Game game1 = new Game("TestGame #1", // title
				LocalDate.of(2022, 10, 28), // release date LocalDate
				null, // member list
				null, // tournament list
				null); // additional notes

		HibernateUtil.getSession().persist(game1);

		// test Game
		Game game2 = new Game("TestGame 22222222", // title
				LocalDate.of(2022, 10, 28), // release date LocalDate
				null, // member list
				null, // tournament list
				null); // additional notes
		HibernateUtil.getSession().persist(game2);

		// Connect games to members --- ManyToMany custom Class
		// Every New Entry/Row needs its own MembersGames Object

		MemberGames memberGames1 = new MemberGames();
		memberGames1.setGame(game1);
		memberGames1.setMember(ulli); // add member
		HibernateUtil.getSession().saveOrUpdate(memberGames1);

		MemberGames memberGames2 = new MemberGames();
		memberGames2.setGame(game2); // specify game
		memberGames2.setMember(ulli); // add member
		HibernateUtil.getSession().saveOrUpdate(memberGames2);

		MemberGames memberGames3 = new MemberGames();
		memberGames3.setGame(game2);
		memberGames3.setMember(hans); // add member
		HibernateUtil.getSession().saveOrUpdate(memberGames3);

		// Connect Tournaments to Teams --- ManyToMany custom Class
		// Every New Entry/Row needs its own TournamentsTeams Object

		TournamentsTeams tournamentTeam1 = new TournamentsTeams();
		tournamentTeam1.setTournament(tournament1);
		tournamentTeam1.setTeam(t1); // add member
		HibernateUtil.getSession().saveOrUpdate(tournamentTeam1);

		TournamentsTeams tournamentTeam2 = new TournamentsTeams();
		tournamentTeam2.setTournament(tournament1); // specify game
		tournamentTeam2.setTeam(t2); // add member

		HibernateUtil.getSession().saveOrUpdate(tournamentTeam2);

		// Connect Tournament to Game --- ManyToMany custom Class
		// Every New Entry/Row needs its own TournamentGame Object

		TournamentGame tournamentGame1 = new TournamentGame();
		tournamentGame1.setTournament(tournament1);
		tournamentGame1.setGame(game1); // add member
		HibernateUtil.getSession().saveOrUpdate(tournamentGame1);

		TournamentGame tournamentGame2 = new TournamentGame();
		tournamentGame2.setTournament(tournament2); // specify game
		tournamentGame2.setGame(game2); // add member

		HibernateUtil.getSession().saveOrUpdate(tournamentGame2);

		// test tournament to game

		// Create news Event
		Event event1 = new Event("erstes event", // event title
				"event descr", // eventdescription
				LocalDate.of(1990, 8, 30), // tournament date
				LocalTime.of(22, 58), // start time
				LocalTime.of(2, 30), // end time
				"lorem ipsum", // additional notes
				false, // reoccuring
				null); // members
		HibernateUtil.getSession().persist(event1);

		Event event2 = new Event("party event", // event title
				"event descr", // eventdescription
				LocalDate.of(1990, 8, 30), // tournament date
				LocalTime.of(22, 58), // start time
				LocalTime.of(2, 30), // end time
				"lorem ipsum", // additional notes
				false, // reoccuring
				null); // members
		HibernateUtil.getSession().persist(event2);

		// Connect Events to members --- ManyToMany custom Class
		// Every New Entry/Row needs its own Membervents Object

		MemberEvents memberEvents1 = new MemberEvents();
		memberEvents1.setEvent(event1);
		memberEvents1.setMember(ulli); // add member
		HibernateUtil.getSession().saveOrUpdate(memberEvents1);

		MemberEvents memberEvents2 = new MemberEvents();
		memberEvents2.setEvent(event2); // specify game
		memberEvents2.setMember(ulli); // add member

		HibernateUtil.getSession().saveOrUpdate(memberEvents2);

		Expense e1 = new Expense("test", // title
				"ttttt", // desc
				500.00, // amount
				LocalDate.of(1981, 4, 11), // date
				"heinrich" // recipient
		);
		HibernateUtil.getSession().persist(e1);

		Expense e2 = new Expense("test", // title
				"ttttt", // desc
				500.00, // amount
				LocalDate.of(1981, 4, 11), // date
				"heinrich" // recipient
		);

		HibernateUtil.getSession().persist(e2);

		Expense e3 = new Expense("test", // title
				"ttttt", // desc
				1000.00, // amount
				LocalDate.of(1981, 4, 11), // date
				"heinrich" // recipient
		);
		HibernateUtil.getSession().persist(e3);

		Revenue r1 = new Revenue("Revenue", // title
				"earnings", // desc
				5000, // amount
				LocalDate.of(1981, 4, 11)); // date

		HibernateUtil.getSession().persist(r1);

		Revenue r2 = new Revenue("Revenue", // title
				"earnings", // desc
				2000, // amount
				LocalDate.of(1981, 4, 11)); // date

		HibernateUtil.getSession().persist(r2);

		Revenue r3 = new Revenue("Revenue", // title
				"earnings", // desc
				1000, // amount
				LocalDate.of(1981, 4, 11)); // date

		HibernateUtil.getSession().persist(r3);

		Partner p1 = new Partner("111111111", // company name
				"ttttt", // contact person name
				"tttttt 1", // contact person phone
				"contact@mail.com", // contact person mail
				"dfvdfv", // first name
				"rororor", // last name
				"StreetCompany", // adress street
				"99", // addess number
				"2345", // post code
				"Dublin", // city
				"Ireland", // country
				"company@company.com", // email
				"+43 677 678 643 44" // phone
		); // reveues

		HibernateUtil.getSession().persist(p1);

		Partner p2 = new Partner("22222222222222", // company name
				"ttttt", // contact person name
				"tttttt 1", // contact person phone
				"contact@mail.com", // contact person mail
				"dfvdfv", // first name
				"rororor", // last name
				"StreetCompany", // adress street
				"99", // addess number
				"2345", // post code
				"Dublin", // city
				"Ireland", // country
				"company@company.com", // email
				"+43 677 678 643 44" // phone
		); // reveues

		HibernateUtil.getSession().persist(p2);

		Partner p3 = new Partner("3333333333333", // company name
				"ttttt", // contact person name
				"tttttt 1", // contact person phone
				"contact@mail.com", // contact person mail
				"dfvdfv", // first name
				"rororor", // last name
				"StreetCompany", // adress street
				"99", // addess number
				"2345", // post code
				"Dublin", // city
				"Ireland", // country
				"company@company.com", // email
				"+43 677 678 643 44" // phone
		); // reveues

		HibernateUtil.getSession().persist(p3);

		HibernateUtil.sessionCommit();
	}
}

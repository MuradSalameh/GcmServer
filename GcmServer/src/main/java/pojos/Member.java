package main.java.pojos;

import java.time.LocalDate;

public class Member extends GcmUser {
	
	private Game[] games;
	private Team[] teams;	
	private LocalDate birthday;
	
	public Member(int id, String firstName, String lastName, String adressStreet, String adressStreetNumber,
			String adressPostCode, String adressCountry, String email, String phoneNumber, Role roles, Social socials,
			Game[] games, Team[] teams, LocalDate birthday) {
		super(id, firstName, lastName, adressStreet, adressStreetNumber, adressPostCode, adressCountry, email,
				phoneNumber, roles, socials);
		this.games = games;
		this.teams = teams;
		this.birthday = birthday;
	}

	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
	
	
}
package main.java.hibernate.model;

import java.time.LocalDate;

public class Member extends GcmUser {
	
	private Game[] games;
	private Team[] teams;	
	private LocalDate birthday;
	
	
	
	public Member() {
		super();
	}



	public Member(Game[] games, Team[] teams, LocalDate birthday) {
		super();
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
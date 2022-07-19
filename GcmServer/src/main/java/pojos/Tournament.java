package main.java.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tournament {
	
	private int id;
	private String touramentTitle;
	private Game game;
	private String tournamentDescription;
	private LocalDate tournamentDate;
	private LocalTime tournamentTimeBeginn;
	private LocalTime tournamentTimeEnd;
	private Team[] teams;
	private String result;
	
	public Tournament(int id, String touramentTitle, Game game, String tournamentDescription, LocalDate tournamentDate,
			LocalTime tournamentTimeBeginn, LocalTime tournamentTimeEnd, Team[] teams, String result) {
		super();
		this.id = id;
		this.touramentTitle = touramentTitle;
		this.game = game;
		this.tournamentDescription = tournamentDescription;
		this.tournamentDate = tournamentDate;
		this.tournamentTimeBeginn = tournamentTimeBeginn;
		this.tournamentTimeEnd = tournamentTimeEnd;
		this.teams = teams;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTouramentTitle() {
		return touramentTitle;
	}

	public void setTouramentTitle(String touramentTitle) {
		this.touramentTitle = touramentTitle;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getTournamentDescription() {
		return tournamentDescription;
	}

	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}

	public LocalDate getTournamentDate() {
		return tournamentDate;
	}

	public void setTournamentDate(LocalDate tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public LocalTime getTournamentTimeBeginn() {
		return tournamentTimeBeginn;
	}

	public void setTournamentTimeBeginn(LocalTime tournamentTimeBeginn) {
		this.tournamentTimeBeginn = tournamentTimeBeginn;
	}

	public LocalTime getTournamentTimeEnd() {
		return tournamentTimeEnd;
	}

	public void setTournamentTimeEnd(LocalTime tournamentTimeEnd) {
		this.tournamentTimeEnd = tournamentTimeEnd;
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	

}

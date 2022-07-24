package main.java.hibernate.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tounament")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "tournament_title")
	private String touramentTitle;
	
	@Column(name = "game")
	private Game game;
	
	@Column(name = "tournament_description")
	private String tournamentDescription;
	
	@Column(name = "tournament_date")
	private LocalDate tournamentDate;
	
	@Column(name = "tournament_time_beginn")
	private LocalTime tournamentTimeBeginn;
	
	@Column(name = "tournament_time_end")
	private LocalTime tournamentTimeEnd;
	
	// join table for tournament teams
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "tournament_teams", 
        joinColumns = { @JoinColumn(name = "tournament_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "team_id") }
    )	
	List<Team> teams = new ArrayList<>();
	
	
	@Column(name = "tournament_result")
	private String tournamentResult;

	
	
	public Tournament() {
		super();
	}



	public Tournament(String touramentTitle, Game game, String tournamentDescription, LocalDate tournamentDate,
			LocalTime tournamentTimeBeginn, LocalTime tournamentTimeEnd, List<Team> teams, String tournamentResult) {
		super();
		this.touramentTitle = touramentTitle;
		this.game = game;
		this.tournamentDescription = tournamentDescription;
		this.tournamentDate = tournamentDate;
		this.tournamentTimeBeginn = tournamentTimeBeginn;
		this.tournamentTimeEnd = tournamentTimeEnd;
		this.teams = teams;
		this.tournamentResult = tournamentResult;
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



	public List<Team> getTeams() {
		return teams;
	}



	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}



	public String getTournamentResult() {
		return tournamentResult;
	}



	public void setTournamentResult(String tournamentResult) {
		this.tournamentResult = tournamentResult;
	}



	public int getId() {
		return id;
	}

	
	
}
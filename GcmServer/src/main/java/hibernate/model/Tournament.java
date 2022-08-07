package main.java.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement
@Entity
@Table(name = "tournament")
public class Tournament  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "tournament_title")
	private String touramentTitle;

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
	Set<Team> teams = new HashSet<>();


	// join column for game tournaments
	
	@ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
    

	@Column(name = "tournament_result")
	private String tournamentResult;

	/*
	@PreRemove
	public void checkAssociationBeforeRemoval() {
		if(!this.teams.isEmpty()) {
			throw new RuntimeException("Can't remove Tournament that has teams");
		}
	}
*/

	public Tournament() {
		super();
	}



	public Tournament(String touramentTitle, String tournamentDescription, LocalDate tournamentDate,
			LocalTime tournamentTimeBeginn, LocalTime tournamentTimeEnd, Set<Team> teams,Game game,
			String tournamentResult) {
		super();
		this.touramentTitle = touramentTitle;
		this.tournamentDescription = tournamentDescription;
		this.tournamentDate = tournamentDate;
		this.tournamentTimeBeginn = tournamentTimeBeginn;
		this.tournamentTimeEnd = tournamentTimeEnd;
		this.teams = teams;
		this.game = game;
		this.tournamentResult = tournamentResult;
	}


	@XmlElement(name="TournamentTitle")
	public String getTouramentTitle() {
		return touramentTitle;
	}



	public void setTouramentTitle(String touramentTitle) {
		this.touramentTitle = touramentTitle;
	}


	@XmlElement(name="TournamentDescription")
	public String getTournamentDescription() {
		return tournamentDescription;
	}



	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}


	@XmlJavaTypeAdapter(value= LocalDateAdapter.class)
	@XmlElement(name="TournamentDate")
	public LocalDate getTournamentDate() {
		return tournamentDate;
	}



	public void setTournamentDate(LocalDate tournamentDate) {
		this.tournamentDate = tournamentDate;
	}


	@XmlJavaTypeAdapter(value= LocalTimeAdapter.class)
	@XmlElement(name="TournamentTimeBeginn")
	public LocalTime getTournamentTimeBeginn() {
		return tournamentTimeBeginn;
	}



	public void setTournamentTimeBeginn(LocalTime tournamentTimeBeginn) {
		this.tournamentTimeBeginn = tournamentTimeBeginn;
	}


	@XmlJavaTypeAdapter(value= LocalTimeAdapter.class)
	@XmlElement(name="TournamentTimeEnd")
	public LocalTime getTournamentTimeEnd() {
		return tournamentTimeEnd;
	}



	public void setTournamentTimeEnd(LocalTime tournamentTimeEnd) {
		this.tournamentTimeEnd = tournamentTimeEnd;
	}


@XmlTransient
	public Set<Team> getTeams() {
		return teams;
	}



	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}


	@XmlElement(name="Game")
	public Game getGame() {
		return game;
	}



	public void setGame(Game game) {
		this.game = game;
	}


	@XmlElement(name="TournamentResult")
	public String getTournamentResult() {
		return tournamentResult;
	}



	public void setTournamentResult(String tournamentResult) {
		this.tournamentResult = tournamentResult;
	}


	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "\nTournament [id=" + id 
				+ "\ntouramentTitle=" + touramentTitle 
				+ "\ntournamentDescription="+ tournamentDescription 
				+ "\ntournamentDate=" + tournamentDate 
				+ "\ntournamentTimeBeginn="	+ tournamentTimeBeginn 
				+ "\ntournamentTimeEnd=" + tournamentTimeEnd 
				+ "\ngame=" + game
				+ "\ntournamentResult=" + tournamentResult 
				+ "\n----------------------------------"
				+ "\n";
	}



}
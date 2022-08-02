package main.java.hibernate.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "game_title")
	private String gameTitle;


	@Column(name = "release_date")
	private LocalDate releaseDate;

	// join table genre games
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name="game_genre",
			joinColumns = @JoinColumn( name="game_id"),
			inverseJoinColumns = @JoinColumn( name="genre_id")
			)
	List<Genre> genres = new ArrayList<Genre>();

	
	
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(
			name = "game_member", 
			joinColumns = { @JoinColumn(name = "game_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "member_id") }
			)
	Set<Member> members = new HashSet<>();
	
	
		
	// join column tournament game
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "game_id")
    List<Tournament> tournaments = new ArrayList<Tournament>();
	
	
	@Column(name = "game_additional_notes")
	private String gameAdditionalNotes;



	public Game() {
		super();
	}



	public Game(String gameTitle, LocalDate releaseDate, List<Genre> genres, Set<Member> members,
			List<Tournament> tournaments, String gameAdditionalNotes) {
		super();
		this.gameTitle = gameTitle;
		this.releaseDate = releaseDate;
		this.genres = genres;
		this.members = members;
		this.tournaments = tournaments;
		this.gameAdditionalNotes = gameAdditionalNotes;
	}



	public String getGameTitle() {
		return gameTitle;
	}



	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}



	public LocalDate getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}



	public List<Genre> getGenres() {
		return genres;
	}



	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}



	public Set<Member> getMembers() {
		return members;
	}



	public void setMembers(Set<Member> members) {
		this.members = members;
	}



	public List<Tournament> getTournaments() {
		return tournaments;
	}



	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}



	public String getGameAdditionalNotes() {
		return gameAdditionalNotes;
	}



	public void setGameAdditionalNotes(String gameAdditionalNotes) {
		this.gameAdditionalNotes = gameAdditionalNotes;
	}



	public int getId() {
		return id;
	}


	
}
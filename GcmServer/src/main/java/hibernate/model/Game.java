package main.java.hibernate.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

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
	
	//join table members games
	@ManyToMany(mappedBy = "games")
    List<Member> members = new ArrayList<>();
	
	
	@Column(name = "game_additional_notes")
	private String gameAddidionalNotes;
	
	

	public Game() {
		super();
	}


	public Game(String gameTitle, LocalDate releaseDate, List<Genre> genres, String gameAddidionalNotes) {
		super();
		this.gameTitle = gameTitle;
		this.releaseDate = releaseDate;
		this.genres = genres;
		this.gameAddidionalNotes = gameAddidionalNotes;
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


	public String getGameAddidionalNotes() {
		return gameAddidionalNotes;
	}


	public void setGameAddidionalNotes(String gameAddidionalNotes) {
		this.gameAddidionalNotes = gameAddidionalNotes;
	}


	public int getId() {
		return id;
	}

	

}

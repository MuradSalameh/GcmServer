package main.java.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "GameGenres")

@Entity
@Table(name = "game_genres")
public class GameGenres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;	

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
	private Game  game;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
	private Genre  genre;


	public GameGenres() {
		super();
	}


	public GameGenres(int id, Genre genre, Game game) {
		super();
		this.id = id;
		this.genre = genre;
		this.game = game;
	}

	
	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name="Genre")
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@XmlElement(name="Game")
	public Game getGame() {
		return game;
	}

	public void setGame(Game gameId) {
		this.game = gameId;
	}

	@Override
	public String toString() {
		return "\nGenreGames "
				+ "\ngenreId=" + genre.getGenreTitle()
				+ "\ngameId=" + game.getGameTitle()
				+ "\n----------------------------------"
				+ "\n";
	}
}

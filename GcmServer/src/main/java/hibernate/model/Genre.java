package main.java.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "genre_title")
	private String genreTitle;	

	@ManyToMany(mappedBy = "genres")
    List<Game> games = new ArrayList<>();

	public Genre() {
		super();
	}

	public Genre(String genreTitle, List<Game> games) {
		super();
		this.genreTitle = genreTitle;
		this.games = games;
	}

	public String getGenreTitle() {
		return genreTitle;
	}

	public void setGenreTitle(String genreTitle) {
		this.genreTitle = genreTitle;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public int getId() {
		return id;
	}

	
	

}

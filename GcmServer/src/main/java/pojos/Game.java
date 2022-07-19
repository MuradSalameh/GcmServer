package main.java.pojos;

import java.time.LocalDate;
import java.util.Arrays;

public class Game {
	private int id;
	private String gameTitle;
	private LocalDate gameReleaseDate;
	private Genre[] gameGenres;
	private String gameAddidionalNotes;
	
	public Game(int id, String gameTitle, LocalDate gameReleaseDate, Genre[] gameGenres, String gameAddidionalNotes) {
		super();
		this.id = id;
		this.gameTitle = gameTitle;
		this.gameReleaseDate = gameReleaseDate;
		this.gameGenres = gameGenres;
		this.gameAddidionalNotes = gameAddidionalNotes;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public LocalDate getGameReleaseDate() {
		return gameReleaseDate;
	}

	public void setGameReleaseDate(LocalDate gameReleaseDate) {
		this.gameReleaseDate = gameReleaseDate;
	}

	public Genre[] getGameGenres() {
		return gameGenres;
	}

	public void setGameGenres(Genre[] gameGenres) {
		this.gameGenres = gameGenres;
	}

	public String getGameAddidionalNotes() {
		return gameAddidionalNotes;
	}

	public void setGameAddidionalNotes(String gameAddidionalNotes) {
		this.gameAddidionalNotes = gameAddidionalNotes;
	}

	@Override
	public String toString() {
		return "Game [gameTitle=" + gameTitle + ", gameReleaseDate=" + gameReleaseDate + ", gameGenres="
				+ Arrays.toString(gameGenres) + ", gameAddidionalNotes=" + gameAddidionalNotes + "]";
	}
	
	
	
	

}

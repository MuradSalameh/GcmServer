package main.java.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
@XmlRootElement
@Entity
@Table(name = "genre")
public class Genre  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "genre_title")
	private String genreTitle;	

	@OneToMany(mappedBy = "genre")
	private Set<GameGenres> gameGenres = new HashSet<>();
 
	
	public Genre() {
		super();
	}
	
	public Genre(String genreTitle, Set<GameGenres> gameGenres) {
		super();
		this.genreTitle = genreTitle;
		this.gameGenres = gameGenres;
	}
	

	@XmlElement(name="GenreTitle")
	public String getGenreTitle() {
		return genreTitle;
	}

	public void setGenreTitle(String genreTitle) {
		this.genreTitle = genreTitle;
	}

	@XmlTransient
	public Set<GameGenres> getGameGenres() {
		return gameGenres;
	}

	public void setGameGenres(Set<GameGenres> gameGenres) {
		this.gameGenres = gameGenres;
	}

	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "\nGenre id=" + id 
				+ "\ngenreTitle=" + genreTitle
				+ "\n----------------------------------"
				+ "\n";
	}
}

package main.java.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TournamentGame")

@Entity
@Table(name = "tournament_game")
public class TournamentGame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	// @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;

	public TournamentGame() {
		super();
	}

	public TournamentGame(int id, Tournament tournament, Game game) {
		super();
		this.id = id;
		this.tournament = tournament;
		this.game = game;
	}

	@XmlElement(name = "ID", required = true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "Tournament")
	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	@XmlElement(name = "Game")
	public Game getGame() {
		return game;
	}

	public void setGame(Game gameId) {
		this.game = gameId;
	}

	@Override
	public String toString() {
		return "\nTournamentGames " + "\ntournamentId=" + tournament.getTouramentTitle() + "\ngameId="
				+ game.getGameTitle() + "\n----------------------------------" + "\n";
	}

}

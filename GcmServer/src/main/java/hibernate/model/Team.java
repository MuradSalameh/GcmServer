package main.java.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;	

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_description")
	private String teamDescription;
	
	//join table for teams
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "member_team", 
			joinColumns = { @JoinColumn(name = "team_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "member_id") }
			)	
	List<Member> members = new ArrayList<>();

	
	public Team() {
		super();
	}


	public Team(String teamName, String teamDescription, List<Member> members) {
		super();
		this.teamName = teamName;
		this.teamDescription = teamDescription;
		this.members = members;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getTeamDescription() {
		return teamDescription;
	}


	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}


	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}


	public int getId() {
		return id;
	}
	
	

}


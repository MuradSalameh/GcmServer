package main.java.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	//join table for members
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


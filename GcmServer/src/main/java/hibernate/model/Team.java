package main.java.hibernate.model;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "team")
public class Team  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;	

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_description")
	private String teamDescription;
	
	
	
	
	
	
	
	@ManyToMany(mappedBy = "teams")
		private Set<Member> members = new HashSet<>();	

	
	public Team() {
		super();
	}


	public Team(String teamName, String teamDescription, Set<Member> members) {
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


	public Set<Member> getMembers() {
		return members;
	}


	public void setMembers(Set<Member> members) {
		this.members = members;
	}


	public int getId() {
		return id;
	}



}


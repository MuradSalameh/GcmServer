package main.java.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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

	@XmlElement(name="Teamname")
	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	@XmlElement(name="TeamDescription")
	public String getTeamDescription() {
		return teamDescription;
	}


	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}

	@XmlTransient
	public Set<Member> getMembers() {
		return members;
	}


	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "\nTeam [id=" + id 
				+ "\nteamName=" + teamName 
				+ "\nteamDescription=" + teamDescription 				
				+ "\n----------------------------------"
				+ "\n";
	}


}


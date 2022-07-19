package main.java.hibernate.model;

public class Team {
	
	private int id;	
	private String teamName;
	private String teamDescription;
	
	public Team(int id, String teamName, String teamDescription) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamDescription = teamDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	
}


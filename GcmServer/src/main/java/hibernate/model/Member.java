package main.java.hibernate.model;

import java.time.LocalDate;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;	

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;	

	@Column(name = "address_street")
	private String adressStreet;

	@Column(name = "address_number")
	private String adressNumber;

	@Column(name = "address_postcode")
	private String adressPostCode;

	@Column(name = "address_city")
	private String adressCity;	

	@Column(name = "country")
	private String country;	

	@Column(name = "email")
	private String email;	

	@Column(name = "phone_number")
	private String phoneNumber;	
	

	//join table for member roles
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="member_roles",
			joinColumns = @JoinColumn( name="member_id"),
			inverseJoinColumns = @JoinColumn( name="role_id")
			)
	List<Role> roles = new ArrayList<>();

	
	//join table for member socials
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="member_socials",
			joinColumns = @JoinColumn( name="member_id"),
			inverseJoinColumns = @JoinColumn( name="social_id")
			)
	List<Social> socials = new ArrayList<>();

	
	//join table for games
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "member_game", 
			joinColumns = { @JoinColumn(name = "member_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "game_id") }
			)
	List<Game> games = new ArrayList<>();

	
	@Column(name = "birthday")
	private LocalDate birthday;

	
	//join table for teams
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "member_team", 
			joinColumns = { @JoinColumn(name = "member_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "team_id") }
			)	
	List<Team> teams = new ArrayList<>();


	public Member() {
		super();
	}


	public Member(String firstName, String lastName, String adressStreet, String adressNumber, String adressPostCode,
			String adressCity, String country, String email, String phoneNumber, List<Role> roles, List<Social> socials,
			List<Game> games, LocalDate birthday, List<Team> teams) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adressStreet = adressStreet;
		this.adressNumber = adressNumber;
		this.adressPostCode = adressPostCode;
		this.adressCity = adressCity;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
		this.socials = socials;
		this.games = games;
		this.birthday = birthday;
		this.teams = teams;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAdressStreet() {
		return adressStreet;
	}


	public void setAdressStreet(String adressStreet) {
		this.adressStreet = adressStreet;
	}


	public String getAdressNumber() {
		return adressNumber;
	}


	public void setAdressNumber(String adressNumber) {
		this.adressNumber = adressNumber;
	}


	public String getAdressPostCode() {
		return adressPostCode;
	}


	public void setAdressPostCode(String adressPostCode) {
		this.adressPostCode = adressPostCode;
	}


	public String getAdressCity() {
		return adressCity;
	}


	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public List<Social> getSocials() {
		return socials;
	}


	public void setSocials(List<Social> socials) {
		this.socials = socials;
	}


	public List<Game> getGames() {
		return games;
	}


	public void setGames(List<Game> games) {
		this.games = games;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}


	public int getId() {
		return id;
	}




}
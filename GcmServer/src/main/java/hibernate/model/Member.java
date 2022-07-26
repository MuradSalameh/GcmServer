package main.java.hibernate.model;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String addressStreet;

	@Column(name = "address_number")
	private String addressNumber;

	@Column(name = "address_postcode")
	private String addressPostCode;

	@Column(name = "address_city")
	private String addressCity;	

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

	
	@ManyToMany(mappedBy = "members")
	List<Team> teams = new ArrayList<>();


	public Member() {
		super();
	}


	public Member(String firstName, String lastName, String addressStreet, String addressNumber, String addressPostCode,
			String addressCity, String country, String email, String phoneNumber, List<Role> roles, List<Social> socials,
			List<Game> games, LocalDate birthday, List<Team> teams) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressStreet = addressStreet;
		this.addressNumber = addressNumber;
		this.addressPostCode = addressPostCode;
		this.addressCity = addressCity;
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


	public String getAddressStreet() {
		return addressStreet;
	}


	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}


	public String getAddressNumber() {
		return addressNumber;
	}


	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}


	public String getAddressPostCode() {
		return addressPostCode;
	}


	public void setAddressPostCode(String addressPostCode) {
		this.addressPostCode = addressPostCode;
	}


	public String getAddressCity() {
		return addressCity;
	}


	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
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
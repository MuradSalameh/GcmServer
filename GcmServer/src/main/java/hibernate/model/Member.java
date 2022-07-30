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

	@Column(name = "clan_name")
	private String clanName;

	@Column(name = "clan_id")
	private String clanId;	

	@Column(name = "realName")
	private String realName;

	@Column(name = "address")
	private String address;
	
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
	@ManyToMany(cascade = { CascadeType.ALL})
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


	public Member(String clanName, String clanId, String realName, String address, String addressPostCode,
			String addressCity, String country, String email, String phoneNumber, List<Role> roles,
			List<Social> socials, List<Game> games, LocalDate birthday, List<Team> teams) {
		super();
		this.clanName = clanName;
		this.clanId = clanId;
		this.realName = realName;
		this.address = address;
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


	public String getClanName() {
		return clanName;
	}


	public void setClanName(String clanName) {
		this.clanName = clanName;
	}


	public String getClanId() {
		return clanId;
	}


	public void setClanId(String clanId) {
		this.clanId = clanId;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	@Override
	public String toString() {
		return "Member [id=" + id + ", clanName=" + clanName + ", clanId=" + clanId + ", realName=" + realName
				+ ", address=" + address + ", addressPostCode=" + addressPostCode + ", addressCity=" + addressCity
				+ ", country=" + country + ", email=" + email + ", phoneNumber=" + phoneNumber + ", birthday="
				+ birthday + "]";
	}

}
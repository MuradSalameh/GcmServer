package main.java.hibernate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gcmuser")
public class GcmUser {

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

	// One User can have many roles
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//
	@JoinColumn(name = "user_role", referencedColumnName = "id")
	List<Role> roles = new ArrayList<>();

	// One User can have many socials
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//
	@JoinColumn(name = "user_social", referencedColumnName = "id")
	List<Social> socials = new ArrayList<>();
	

	public GcmUser() {
		super();
	}


	public GcmUser(String firstName, String lastName, String adressStreet, String adressNumber, String adressPostCode,
			String adressCity, String country, String email, String phoneNumber, List<Role> roles,
			List<Social> socials) {
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


	public int getId() {
		return id;
	}
	
	
}
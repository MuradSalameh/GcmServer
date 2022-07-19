package main.java.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gcmuser")
public class GcmUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
	
	@Column(name = "country")
	private String country;	
	
	@Column(name = "email")
	private String email;	
	
	@Column(name = "phone_number")
	private String phoneNumber;	
	
	@Column(name = "roles")
	private Role[] roles;
	
	@Column(name = "socials")
	private Social[] socials;
	
		
	public GcmUser() {
		super();
	}


	public GcmUser(int id, String firstName, String lastName, String adressStreet, String adressNumber,
			String adressPostCode, String country, String email, String phoneNumber, Role[] roles, Social[] socials) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adressStreet = adressStreet;
		this.adressNumber = adressNumber;
		this.adressPostCode = adressPostCode;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
		this.socials = socials;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Role[] getRoles() {
		return roles;
	}


	public void setRoles(Role[] roles) {
		this.roles = roles;
	}


	public Social[] getSocials() {
		return socials;
	}


	public void setSocials(Social[] socials) {
		this.socials = socials;
	}
	
	

}
package main.java.hibernate.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "partner")
public class Partner implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;		

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "contact_person_name")
	private String contactPersonName;
	
	@Column(name = "contact_person_phone")
	private String contactPersonPhone;
	
	@Column(name = "contact_person_mail")
	private String contactPersonMail;

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

	//join table for partner socials
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
            name="partner_socials",
            joinColumns = @JoinColumn( name="partner_id"),
            inverseJoinColumns = @JoinColumn( name="social_id")
    )
	List<Social> socials = new ArrayList<>();
	
	//join table for partner revenue
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name="partner_revenue",
			joinColumns = @JoinColumn( name="partner_id"),
			inverseJoinColumns = @JoinColumn( name="revenue_id")
			)
	List<Revenue> revenues = new ArrayList<>();

	
	public Partner() {
		super();
	}


	public Partner(String companyName, String contactPersonName, String contactPersonPhone, String contactPersonMail,
			String firstName, String lastName, String adressStreet, String adressNumber, String adressPostCode,
			String adressCity, String country, String email, String phoneNumber, List<Social> socials,
			List<Revenue> revenues) {
		super();
		this.companyName = companyName;
		this.contactPersonName = contactPersonName;
		this.contactPersonPhone = contactPersonPhone;
		this.contactPersonMail = contactPersonMail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adressStreet = adressStreet;
		this.adressNumber = adressNumber;
		this.adressPostCode = adressPostCode;
		this.adressCity = adressCity;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.socials = socials;
		this.revenues = revenues;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getContactPersonName() {
		return contactPersonName;
	}


	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}


	public String getContactPersonPhone() {
		return contactPersonPhone;
	}


	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}


	public String getContactPersonMail() {
		return contactPersonMail;
	}


	public void setContactPersonMail(String contactPersonMail) {
		this.contactPersonMail = contactPersonMail;
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


	public List<Social> getSocials() {
		return socials;
	}


	public void setSocials(List<Social> socials) {
		this.socials = socials;
	}


	public List<Revenue> getRevenues() {
		return revenues;
	}


	public void setRevenues(List<Revenue> revenues) {
		this.revenues = revenues;
	}


	public int getId() {
		return id;
	}	

}

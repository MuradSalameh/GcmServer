package main.java.pojos;




public class GcmUser {
	
	private int id;	
	private String firstName;	
	private String lastName;	
	private String adressStreet;	
	private String adressStreetNumber;		
	private String adressPostCode;	
	private String adressCountry;	
	private String email;	
	private String phoneNumber;	
	private Role roles;
	private Social socials;
	
	public GcmUser(int id, String firstName, String lastName, String adressStreet, String adressStreetNumber,
			String adressPostCode, String adressCountry, String email, String phoneNumber, Role roles, Social socials) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adressStreet = adressStreet;
		this.adressStreetNumber = adressStreetNumber;
		this.adressPostCode = adressPostCode;
		this.adressCountry = adressCountry;
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

	public String getAdressStreetNumber() {
		return adressStreetNumber;
	}

	public void setAdressStreetNumber(String adressStreetNumber) {
		this.adressStreetNumber = adressStreetNumber;
	}

	public String getAdressPostCode() {
		return adressPostCode;
	}

	public void setAdressPostCode(String adressPostCode) {
		this.adressPostCode = adressPostCode;
	}

	public String getAdressCountry() {
		return adressCountry;
	}

	public void setAdressCountry(String adressCountry) {
		this.adressCountry = adressCountry;
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

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Social getSocials() {
		return socials;
	}

	public void setSocials(Social socials) {
		this.socials = socials;
	}
	
	
	
	
	
	}
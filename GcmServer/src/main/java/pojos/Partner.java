package main.java.pojos;

public class Partner extends GcmUser{
	
	private String companyName;
	private String contactPersonName;
	private String contactPersonPhone;
	private String contactPersonMail;
	
	
	public Partner(int id, String firstName, String lastName, String adressStreet, String adressStreetNumber,
			String adressPostCode, String adressCountry, String email, String phoneNumber, Role roles, Social socials,
			String companyName, String contactPersonName, String contactPersonPhone, String contactPersonMail) {
		super(id, firstName, lastName, adressStreet, adressStreetNumber, adressPostCode, adressCountry, email,
				phoneNumber, roles, socials);
		this.companyName = companyName;
		this.contactPersonName = contactPersonName;
		this.contactPersonPhone = contactPersonPhone;
		this.contactPersonMail = contactPersonMail;
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
	
	

	
	
	

}

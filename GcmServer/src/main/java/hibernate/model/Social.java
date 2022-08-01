package main.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "social")
public class Social {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "social_platform")
	private String socialPlatform;	
	
	@Column(name = "social_username")
	private String socialUsername;	
	
	@Column(name = "social_link")
	private String socialLink;	
	
	@Column(name = "social_notes")
	private String socialNotes;
	
	public Social() {
		super();
	}

	public Social(String socialPlatform, String socialUsername, String socialLink, String socialNotes) {
		super();
		this.socialPlatform = socialPlatform;
		this.socialUsername = socialUsername;
		this.socialLink = socialLink;
		this.socialNotes = socialNotes;
	}

	public String getSocialPlatform() {
		return socialPlatform;
	}

	public void setSocialPlatform(String socialPlatform) {
		this.socialPlatform = socialPlatform;
	}

	public String getSocialUsername() {
		return socialUsername;
	}

	public void setSocialUsername(String socialUsername) {
		this.socialUsername = socialUsername;
	}

	public String getSocialLink() {
		return socialLink;
	}

	public void setSocialLink(String socialLink) {
		this.socialLink = socialLink;
	}

	public String getSocialNotes() {
		return socialNotes;
	}

	public void setSocialNotes(String socialNotes) {
		this.socialNotes = socialNotes;
	}

	public int getId() {
		return id;
	}
	
	

}


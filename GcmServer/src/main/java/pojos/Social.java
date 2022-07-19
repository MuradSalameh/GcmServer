package main.java.pojos;


public class Social {
	private int id;
	private String socialPlatformName;		
	private String socialPlattformUsername;	
	private String socialLink;	
	private String socialAdditionalNotes;
	
	public Social(int id, String socialPlatformName, String socialPlattformUsername, String socialLink,
			String socialAdditionalNotes) {
		super();
		this.id = id;
		this.socialPlatformName = socialPlatformName;
		this.socialPlattformUsername = socialPlattformUsername;
		this.socialLink = socialLink;
		this.socialAdditionalNotes = socialAdditionalNotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSocialPlatformName() {
		return socialPlatformName;
	}

	public void setSocialPlatformName(String socialPlatformName) {
		this.socialPlatformName = socialPlatformName;
	}

	public String getSocialPlattformUsername() {
		return socialPlattformUsername;
	}

	public void setSocialPlattformUsername(String socialPlattformUsername) {
		this.socialPlattformUsername = socialPlattformUsername;
	}

	public String getSocialLink() {
		return socialLink;
	}

	public void setSocialLink(String socialLink) {
		this.socialLink = socialLink;
	}

	public String getSocialAdditionalNotes() {
		return socialAdditionalNotes;
	}

	public void setSocialAdditionalNotes(String socialAdditionalNotes) {
		this.socialAdditionalNotes = socialAdditionalNotes;
	}
	
	

	

}


package main.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MemberSocials")

@Entity
@Table(name = "member_socials")
public class MemberSocials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;	

	@Column(name = "member_id")
	private int  memberId;

	@Column(name = "social_id")
	private int  socialId;

	public MemberSocials() {
		super();
	}



	public MemberSocials(int id, int memberId, int socialId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.socialId = socialId;
	}


	@XmlElement(name="ID",required=true)
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@XmlElement(name="MemberId")
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@XmlElement(name="SocialId")
	public int getSocialId() {
		return socialId;
	}

	public void setSocialId(int socialId) {
		this.socialId = socialId;
	}

	@Override
	public String toString() {
		return "\nMemberSocials "
				+ "\nmemberId=" + memberId 
				+ "\nsocialId=" + socialId
				+ "\n----------------------------------"
				+ "\n";
	}



}

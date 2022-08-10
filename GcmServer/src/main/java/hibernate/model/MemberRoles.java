package main.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "MemberRoles")

@Entity
@Table(name = "member_roles")
public class MemberRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private int id;	

	@Column(name = "member_id")
	private int  memberId;

	@Column(name = "role_id")
	private int  roleId;

	public MemberRoles() {
		super();
	}



	public MemberRoles(int id, int memberId, int roleId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.roleId = roleId;
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

	@XmlElement(name="RoleId")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "\nMemberRoles "
				+ "\nmemberId=" + memberId 
				+ "\nroleId=" + roleId
				+ "\n----------------------------------"
				+ "\n";
	}



}

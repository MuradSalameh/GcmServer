package main.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;	
	
	@Column(name = "role_name")
	private String roleName;	
	
	@Column(name = "role_description")
	private String roleDescription;
	
	
    
	public Role() {
		super();
	}

	public Role(String roleName, String roleDescription) {
		super();
		
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public int getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
	

}
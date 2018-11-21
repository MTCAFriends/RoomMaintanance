package com.roommaintanance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ROLE")
public class AppUserRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8310938952916966567L;

	@Id
	@GeneratedValue
	@Column( name = "role_id", nullable = false, unique = true )
	private long	roleId;

	@Column( name = "role_name", unique = true )
	@NotNull
	@Size( max = 50 )
	@NotBlank
	private String	roleName;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	

}

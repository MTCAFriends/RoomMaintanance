package com.roommaintanance.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "APP_USERS")
public class AppUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2075138975138116044L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APP_USER_ID", unique = true, nullable = false)
	private int appUserId;
	@Column(name = "APP_USER_EMAIL_ID", unique = true, nullable = false)
	private String appUserEmailID;
	@Column(name = "APP_USER_NAME", nullable = false)
	private String appUserName;
	@NotNull
	@Size( min = 5, max = 200 )
	@NotBlank
	@Column(name = "APP_USER_PASSWORD", nullable = false)
	private String appUserPassword;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "USER_ROLE_M",
	joinColumns = @JoinColumn( name = "app_user_id" ),
	inverseJoinColumns = @JoinColumn( name = "role_id" ) )
    private Set<AppUserRole> appUserRoles = new HashSet<AppUserRole>();
	public int getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}
	public String getAppUserEmailID() {
		return appUserEmailID;
	}
	public void setAppUserEmailID(String appUserEmailID) {
		this.appUserEmailID = appUserEmailID;
	}
	public String getAppUserName() {
		return appUserName;
	}
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	public String getAppUserPassword() {
		return appUserPassword;
	}
	public void setAppUserPassword(String appUserPassword) {
		this.appUserPassword = appUserPassword;
	}
	public Set<AppUserRole> getAppUserRoles() {
		return appUserRoles;
	}
	public void setAppUserRoles(Set<AppUserRole> appUserRoles) {
		this.appUserRoles = appUserRoles;
	}
	@Override
	public String toString() {
		return "AppUser [appUserId=" + appUserId + ", appUserEmailID=" + appUserEmailID + ", appUserName=" + appUserName
				+ ", appUserPassword=" + appUserPassword + ", appUserRoles=" + appUserRoles + "]";
	}
	
	
	
}

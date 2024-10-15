package com.user.login.loginuser.userdetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Users {

	public Users() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	@NotBlank
	private String password;
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	@NotBlank
	@Column(name = "phoneNo")
	private String phoneNo;
	@NotBlank
	@Column(name = "state")
	private String state;

	@NotBlank
	@Column(name = "role")
	private String role;

	@NotBlank
	@Column(name = "status")
	private String status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users(long id, @NotBlank String userName, @NotBlank String password, @NotBlank @Email String email,
			@NotBlank String phoneNo, @NotBlank String state, @NotBlank String role, @NotBlank String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.state = state;
		this.role = role;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", state=" + state + ", role=" + role + ", status=" + status + "]";
	}
	
	

}

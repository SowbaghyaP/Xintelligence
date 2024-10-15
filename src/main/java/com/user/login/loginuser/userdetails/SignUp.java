package com.user.login.loginuser.userdetails;

public class SignUp {

	private String username;
	private String email;
	private String password;
	private String state;
	private String phoneNo;
	private String role;
	private String status;

	public SignUp() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public SignUp(String username, String email, String password, String state, String phoneNo, String role,
			String status) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.state = state;
		this.phoneNo = phoneNo;
		this.role = role;
		this.status = status;
	}

	@Override
	public String toString() {
		return "SignUp [username=" + username + ", email=" + email + ", password=" + password + ", state=" + state
				+ ", phoneNo=" + phoneNo + ", role=" + role + ", status=" + status + "]";
	}
}

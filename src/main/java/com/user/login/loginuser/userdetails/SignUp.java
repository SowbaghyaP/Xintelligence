package com.user.login.loginuser.userdetails;

public class SignUp {
	
    public SignUp(String username, String email, String password, String state, String phoneNo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.state = state;
		this.phoneNo = phoneNo;
	}
	private String username;
    private String email;
    private String password;
    private String state;
    private String phoneNo;
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
}

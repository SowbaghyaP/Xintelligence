package com.user.login.loginuser;

import org.springframework.stereotype.Service;

import com.user.login.loginuser.userdetails.Login;
import com.user.login.loginuser.userdetails.SignUp;
import com.user.login.loginuser.userdetails.Users;

@Service
public class Validation {
	public boolean validateUser(SignUp signup) {

		if (signup.getUsername()==null || signup.getPassword()==null || signup.getPhoneNo()==null
				|| signup.getState()==null || signup.getEmail()==null) 
		{ 
			return true;
		}

		return false;
	}
	public boolean validateLoginUser(Login login) {

		if (login.getUserName()==null || login.getPassword()==null ) 
		{ 
			return true;
		}

		return false;
	}
}

package com.user.login.loginuser.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.login.loginuser.userdetails.Users;

public interface LoginRepository extends JpaRepository<Users, Long> {
	public Users findByUserName(String userName);
	public Users findByPassword(String password);
	public Users findByUserNameAndPassword(String userName,String password);
	public boolean existsByUserName(String userName);
	public boolean existsByEmail(String email);
	


}

package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean, String> {
	// insert update delete select
	//
	public UserBean findByUsername(String userName);
	public UserBean findByPassword(String password);
	//
}


//user_name --> userName  | username 


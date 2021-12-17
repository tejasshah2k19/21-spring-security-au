package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bean.UserBean;
import com.config.CustomUserDetail;
import com.repository.UserRepository;

@Service
public class CustomUsersDetailService implements UserDetailsService {
		@Autowired
		UserRepository userRepo;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			//select * from users where username = ? 
			UserBean user = this.userRepo.findByUsername(username);
			if(user == null) {
				throw new UsernameNotFoundException("Invalid User");
			}
			return new CustomUserDetail(user);
		}


		

}

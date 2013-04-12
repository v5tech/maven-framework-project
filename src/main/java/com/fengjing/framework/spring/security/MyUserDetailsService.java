package com.fengjing.framework.spring.security;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fengjing.framework.spring.security.service.UserService;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	@Resource(name="securityUserServiceImpl")
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userService.findUserByUsername(username);
	}

}

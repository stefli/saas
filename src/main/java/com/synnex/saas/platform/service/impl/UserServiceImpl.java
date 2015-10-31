package com.synnex.saas.platform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.User;
import com.synnex.saas.platform.repository.IUserRepository;
import com.synnex.saas.platform.service.IUserService;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserDetailsService, IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> User login in....");
		User user = userRepository.getUserByUserName(username);
		if (user == null) {
			return null;
		}
		logger.info(">>>>>>>>>>>>>>>>>>>>>>> " + user);
		List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
		List<String> roles = (List<String>) getUserRolesByName(username);
		for (String role : roles) {
			authsList.add(new SimpleGrantedAuthority(role));
		}
		user.setAuthorities(authsList);
		GrantedAuthority[] authorities = authsList.toArray(new GrantedAuthority[authsList.size()]);
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>> User authorities:" + authorities);
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>> User logined");
		return user;
	}

	public List<String> getUserRolesByName(String userName) {
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		return roles;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	/**
	 * Create new user
	 */
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Transactional
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}

}

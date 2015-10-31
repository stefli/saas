package com.synnex.saas.platform.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.User;
import com.synnex.saas.platform.domain.UserAttempts;
import com.synnex.saas.platform.repository.IUserAttemptsRepository;
import com.synnex.saas.platform.repository.IUserRepository;
import com.synnex.saas.platform.service.IUserAttemptsService;

@Service("userAttemptsService")
@Transactional(readOnly = true)
public class UserAttemptsServiceImpl implements IUserAttemptsService {

	private static final int MAX_ATTEMPTS = 3;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IUserAttemptsRepository userAttemptsRepository;

	public UserAttempts getUserAttempts(String userName) {
		return userAttemptsRepository.findUserAttemptsByUserName(userName);
	}

	@Transactional
	public void updateUserAttempts(String userName) {
		UserAttempts userAttempts = getUserAttempts(userName);
		if (null == userAttempts) {
			User user = userRepository.getUserByUserName(userName);
			if (null != user && StringUtils.isNotBlank(user.getUsername())) {
				userAttempts = new UserAttempts();
				userAttempts.setAttempts(1);
				userAttempts.setLastModifiedDt(new Date());
				userAttempts.setUserName(userName);
				userAttemptsRepository.save(userAttempts);
			}
		} else {
			User user = userRepository.getUserByUserName(userName);
			if (null != user && StringUtils.isNotBlank(user.getUsername())) {
				userAttempts.setAttempts(userAttempts.getAttempts() + 1);
				userAttempts.setLastModifiedDt(new Date());
				userAttemptsRepository.save(userAttempts);
			}
			if (userAttempts.getAttempts() + 1 >= MAX_ATTEMPTS) {
				user.setLocked(true);
				userRepository.save(user);
			}
		}
	}

	@Transactional
	public void resetUserAttempts(String userName) {
		UserAttempts userAttempts = getUserAttempts(userName);
		if (null != userAttempts) {
			userAttempts.setAttempts(0);
			userAttemptsRepository.save(userAttempts);
		}
	}

}

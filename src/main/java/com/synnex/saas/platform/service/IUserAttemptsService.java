package com.synnex.saas.platform.service;

import com.synnex.saas.platform.domain.UserAttempts;

public interface IUserAttemptsService {

	UserAttempts getUserAttempts(String userName);

	void updateUserAttempts(String userName);

	void resetUserAttempts(String userName);

}

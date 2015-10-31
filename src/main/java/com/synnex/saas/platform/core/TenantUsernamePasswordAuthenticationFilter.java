package com.synnex.saas.platform.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.core.session.SessionContext;
import com.synnex.saas.platform.domain.UserAttempts;
import com.synnex.saas.platform.service.IUserAttemptsService;
import com.synnex.saas.platform.utils.TenantUtils;

public class TenantUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private IUserAttemptsService userAttemptsService;

	/**
	 * Get addtional parameter when login
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		final String tenantKey = request.getParameter(Constants.TENANT_KEY);
		final String userName = obtainUsername(request);
		request.getSession().setAttribute(Constants.TENANT_KEY, tenantKey);
		SessionContext sessionContext = new SessionContext();
		sessionContext.setContextValue(Constants.TENANT_KEY, TenantUtils.initEMFProperties(tenantKey));
		request.getSession().setAttribute(Constants.SESSION_CONTEXT_KEY, sessionContext);

		Authentication authentication;
		try {
			authentication = super.attemptAuthentication(request, response);
			userAttemptsService.resetUserAttempts(authentication.getName());
			return authentication;
		} catch (BadCredentialsException e) {
			userAttemptsService.updateUserAttempts(userName);
			throw e;
		} catch (LockedException e) {
			String error = "";
			UserAttempts userAttempts = userAttemptsService.getUserAttempts(userName);
			if (null != userAttempts) {
				error = "Exceeds the maximum number of attempts, User account is locked!";
			} else {
				error = e.getMessage();
			}
			throw new LockedException(error);
		}
	}

}

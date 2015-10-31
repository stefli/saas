package com.synnex.saas.platform.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.core.session.SessionContext;
import com.synnex.saas.platform.utils.TenantUtils;

public class PlatformSimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private String defaultSuccessUrl;

	public String getDefaultSuccessUrl() {
		return defaultSuccessUrl;
	}

	public void setDefaultSuccessUrl(String defaultSuccessUrl) {
		this.defaultSuccessUrl = defaultSuccessUrl;
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String tenantKey = request.getParameter(Constants.TENANT_KEY);
		super.setDefaultTargetUrl(defaultSuccessUrl);
		super.onAuthenticationSuccess(request, response, authentication);
		Object principal = authentication.getPrincipal();
		if (principal != null) {
			HttpSession session = request.getSession();
			if (session != null) {
				// Store user & tenant information to session context
				SessionContext sessionContext = new SessionContext();
				sessionContext.setContextValue(Constants.USER_KEY, principal);
				sessionContext.setContextValue(Constants.TENANT_KEY, TenantUtils.initEMFProperties(tenantKey));
				session.setAttribute(Constants.SESSION_CONTEXT_KEY, sessionContext);
			}
		}
	}

}

package com.synnex.saas.platform.core.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.utils.TenantUtils;

public class SessionManager {

	/**
	 * Get session context for application
	 * 
	 * @return
	 * 
	 */
	public static SessionContext getSessionContext() {
		SessionContext sessionContext = null;
		ServletRequestAttributes svr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (svr != null && svr.getRequest() != null) {
			HttpSession session = svr.getRequest().getSession(true);
			if (session != null) {
				sessionContext = (SessionContext) session.getAttribute(Constants.SESSION_CONTEXT_KEY);
				if (sessionContext == null) {
					String tenantKey = (String) session.getAttribute(Constants.TENANT_KEY);
					sessionContext = new SessionContext();
					sessionContext.setContextValue(Constants.TENANT_KEY, TenantUtils.initEMFProperties(tenantKey));
					session.setAttribute(Constants.SESSION_CONTEXT_KEY, sessionContext);
				}
			}
		}
		return sessionContext;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getEMFProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		SessionContext sessionContext = getSessionContext();
		if (sessionContext != null) {
			properties = (HashMap<String, Object>) sessionContext.getContextValue(Constants.TENANT_KEY);
			if (properties == null) {
				return new HashMap<String, Object>();
			}
		}
		return properties;
	}

}

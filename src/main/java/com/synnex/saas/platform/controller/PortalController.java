package com.synnex.saas.platform.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.core.session.SessionContext;
import com.synnex.saas.platform.core.session.SessionManager;

@Controller
public class PortalController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView portal = new ModelAndView();
		portal.setViewName("index");
		return portal;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(WebRequest webRequest) {
		ModelAndView login = new ModelAndView();
		login.setViewName("common/login");
		login.addObject("tenantKey", webRequest.getAttribute(Constants.TENANT_KEY, WebRequest.SCOPE_REQUEST));
		login.addObject("tenantKeyName", Constants.TENANT_KEY);
		Exception exception = (Exception) webRequest.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
				WebRequest.SCOPE_SESSION);
		if (null != exception) {
			login.addObject("errors", exception.getMessage());
		}
		return login;
	}

	@RequestMapping(value = "/portal", method = RequestMethod.GET)
	public ModelAndView portal() {
		ModelAndView portal = new ModelAndView();
		portal.setViewName("portal");
		SessionContext sessionContext = SessionManager.getSessionContext();
		Object principal = sessionContext.getContextValue(Constants.USER_KEY);
		Object tenant = sessionContext.getContextValue(Constants.TENANT_KEY);
		portal.addObject("tenant", tenant);
		portal.addObject("principal", principal);
		return portal;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("profile");
		return profile;
	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings() {
		ModelAndView profile = new ModelAndView();
		profile.setViewName("settings");
		return profile;
	}

	@RequestMapping(value = "/undefined", method = RequestMethod.GET)
	public ModelAndView undefined() {
		ModelAndView undefined = new ModelAndView();
		undefined.setViewName("undefined");
		return undefined;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = "/timeout", method = RequestMethod.GET)
	public ModelAndView sessionTimeout() {
		ModelAndView model = new ModelAndView();
		model.setViewName("timeout");
		return model;
	}

}

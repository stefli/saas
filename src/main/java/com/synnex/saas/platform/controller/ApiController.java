package com.synnex.saas.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.synnex.saas.platform.domain.Tenant;
import com.synnex.saas.platform.service.ITenantService;

@Controller
public class ApiController {

	@Autowired
	ITenantService tenantService;

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView index = new ModelAndView();
		index.setViewName("api/list");
		return index;
	}

	@RequestMapping(value = "/api/tenants", method = RequestMethod.GET)
	@ResponseBody
	public List<Tenant> tenants() {
		List<Tenant> tenants = tenantService.getAllTenants();
		return tenants;
	}

}

package com.synnex.saas.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.synnex.saas.platform.domain.Tenant;
import com.synnex.saas.platform.service.ITenantService;

/**
 * Controller for Tenant maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class TenantController {

	@Autowired
	private ITenantService tenantService;

	/**
	 * List all Tenants page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenants", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("tenant/list");
		Page<Tenant> page = tenantService.getAllTenants(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create Tenant page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenants/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("tenant/create");
		return create;
	}

	/**
	 * Create Tenant page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenant", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("tenant") Tenant tenant) {
		ModelAndView save = new ModelAndView();
		tenantService.saveTenant(tenant);
		save.setViewName("redirect:/tenants");
		return save;
	}

	/**
	 * View Tenant page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenant/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Tenant Tenant = tenantService.getTenantById(id);
		if (Tenant == null) {
			Tenant = new Tenant();
		}
		view.setViewName("tenant/view");
		view.addObject("tenant", Tenant);
		return view;
	}

	/**
	 * Edit Tenant page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenant/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Tenant Tenant = tenantService.getTenantById(id);
		if (Tenant == null) {
			edit.addObject("errors", "Invalid Tenant type!");
			edit.setViewName("redirect:/tenants");
			return edit;
		}
		edit.setViewName("tenant/edit");
		edit.addObject("tenant", Tenant);
		return edit;
	}

	/**
	 * Edit Tenant
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenant/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("tenant") Tenant Tenant) {
		ModelAndView edit = new ModelAndView();
		Tenant TenantInDB = tenantService.getTenantById(id);
		if (TenantInDB == null) {
			edit.addObject("errors", "Invalid Tenant type!");
			edit.setViewName("redirect:/Tenants");
			return edit;
		}
		tenantService.saveTenant(Tenant);
		edit.setViewName("tenant/view");
		edit.addObject("tenant", Tenant);
		return edit;
	}

	/**
	 * Delete Tenant page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/tenant/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/tenants");
		Tenant Tenant = tenantService.getTenantById(id);
		if (Tenant == null) {
			edit.addObject("errors", "Invalid Tenant type!");
			return edit;
		}
		tenantService.deleteTenantById(id);
		return edit;
	}

}

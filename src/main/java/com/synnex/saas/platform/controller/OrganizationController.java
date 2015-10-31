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

import com.synnex.saas.platform.domain.Organization;
import com.synnex.saas.platform.service.IOrganizationService;

/**
 * Controller for Organization maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class OrganizationController {

	@Autowired
	private IOrganizationService organizationService;

	/**
	 * List all Organizations page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organizations", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("organization/list");
		Page<Organization> page = organizationService.getAllOrganizations(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create Organization page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organizations/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("organization/create");
		return create;
	}

	/**
	 * Create Organization page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("organization") Organization organization) {
		ModelAndView save = new ModelAndView();
		organizationService.saveOrganization(organization);
		save.setViewName("redirect:/organizations");
		return save;
	}

	/**
	 * View Organization page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Organization Organization = organizationService.getOrganizationById(id);
		if (Organization == null) {
			Organization = new Organization();
		}
		view.setViewName("organization/view");
		view.addObject("organization", Organization);
		return view;
	}

	/**
	 * Edit Organization page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organization/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Organization Organization = organizationService.getOrganizationById(id);
		if (Organization == null) {
			edit.addObject("errors", "Invalid Organization type!");
			edit.setViewName("redirect:/organizations");
			return edit;
		}
		edit.setViewName("organization/edit");
		edit.addObject("organization", Organization);
		return edit;
	}

	/**
	 * Edit Organization
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("organization") Organization Organization) {
		ModelAndView edit = new ModelAndView();
		Organization OrganizationInDB = organizationService.getOrganizationById(id);
		if (OrganizationInDB == null) {
			edit.addObject("errors", "Invalid Organization type!");
			edit.setViewName("redirect:/Organizations");
			return edit;
		}
		organizationService.saveOrganization(Organization);
		edit.setViewName("organization/view");
		edit.addObject("organization", Organization);
		return edit;
	}

	/**
	 * Delete Organization page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/organizations");
		Organization Organization = organizationService.getOrganizationById(id);
		if (Organization == null) {
			edit.addObject("errors", "Invalid Organization type!");
			return edit;
		}
		organizationService.deleteOrganizationById(id);
		return edit;
	}

}

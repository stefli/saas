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

import com.synnex.saas.platform.domain.Role;
import com.synnex.saas.platform.service.IRoleService;

/**
 * Controller for Role maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class RoleController {

	@Autowired
	private IRoleService roleService;

	/**
	 * List all Roles page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("role/list");
		Page<Role> page = roleService.getAllRoles(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create Role page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/roles/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("role/create");
		return create;
	}

	/**
	 * Create Role page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("role") Role role) {
		ModelAndView save = new ModelAndView();
		roleService.saveRole(role);
		save.setViewName("redirect:/roles");
		return save;
	}

	/**
	 * View Role page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Role Role = roleService.getRoleById(id);
		if (Role == null) {
			Role = new Role();
		}
		view.setViewName("role/view");
		view.addObject("role", Role);
		return view;
	}

	/**
	 * Edit Role page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/role/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Role Role = roleService.getRoleById(id);
		if (Role == null) {
			edit.addObject("errors", "Invalid Role type!");
			edit.setViewName("redirect:/roles");
			return edit;
		}
		edit.setViewName("role/edit");
		edit.addObject("role", Role);
		return edit;
	}

	/**
	 * Edit Role
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("role") Role Role) {
		ModelAndView edit = new ModelAndView();
		Role RoleInDB = roleService.getRoleById(id);
		if (RoleInDB == null) {
			edit.addObject("errors", "Invalid Role type!");
			edit.setViewName("redirect:/Roles");
			return edit;
		}
		roleService.saveRole(Role);
		edit.setViewName("role/view");
		edit.addObject("role", Role);
		return edit;
	}

	/**
	 * Delete Role page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/roles");
		Role Role = roleService.getRoleById(id);
		if (Role == null) {
			edit.addObject("errors", "Invalid Role type!");
			return edit;
		}
		roleService.deleteRoleById(id);
		return edit;
	}

}

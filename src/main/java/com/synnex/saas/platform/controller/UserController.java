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

import com.synnex.saas.platform.domain.User;
import com.synnex.saas.platform.service.IUserService;

/**
 * Controller for User maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * List all Users page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("user/list");
		Page<User> page = userService.getAllUsers(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create User page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/users/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("user/create");
		return create;
	}

	/**
	 * Create User page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") User user) {
		ModelAndView save = new ModelAndView();
		userService.saveUser(user);
		save.setViewName("redirect:/users");
		return save;
	}

	/**
	 * View User page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		User User = userService.getUserById(id);
		if (User == null) {
			User = new User();
		}
		view.setViewName("user/view");
		view.addObject("user", User);
		return view;
	}

	/**
	 * Edit User page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/user/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		User User = userService.getUserById(id);
		if (User == null) {
			edit.addObject("errors", "Invalid User type!");
			edit.setViewName("redirect:/users");
			return edit;
		}
		edit.setViewName("user/edit");
		edit.addObject("user", User);
		return edit;
	}

	/**
	 * Edit User
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("user") User User) {
		ModelAndView edit = new ModelAndView();
		User UserInDB = userService.getUserById(id);
		if (UserInDB == null) {
			edit.addObject("errors", "Invalid User type!");
			edit.setViewName("redirect:/Users");
			return edit;
		}
		userService.saveUser(User);
		edit.setViewName("user/view");
		edit.addObject("user", User);
		return edit;
	}

	/**
	 * Delete User page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/users");
		User User = userService.getUserById(id);
		if (User == null) {
			edit.addObject("errors", "Invalid User type!");
			return edit;
		}
		userService.deleteUserById(id);
		return edit;
	}

}

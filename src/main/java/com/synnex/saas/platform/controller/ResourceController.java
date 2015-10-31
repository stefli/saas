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

import com.synnex.saas.platform.domain.Resource;
import com.synnex.saas.platform.service.IResourceService;

/**
 * Controller for Resource maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class ResourceController {

	@Autowired
	private IResourceService resourceService;

	/**
	 * List all Resources page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("resource/list");
		Page<Resource> page = resourceService.getAllResources(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create Resource page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resources/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("resource/create");
		return create;
	}

	/**
	 * Create Resource page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("resource") Resource resource) {
		ModelAndView save = new ModelAndView();
		resourceService.saveResource(resource);
		save.setViewName("redirect:/resources");
		return save;
	}

	/**
	 * View Resource page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Resource Resource = resourceService.getResourceById(id);
		if (Resource == null) {
			Resource = new Resource();
		}
		view.setViewName("resource/view");
		view.addObject("resource", Resource);
		return view;
	}

	/**
	 * Edit Resource page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resource/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Resource Resource = resourceService.getResourceById(id);
		if (Resource == null) {
			edit.addObject("errors", "Invalid Resource type!");
			edit.setViewName("redirect:/resources");
			return edit;
		}
		edit.setViewName("resource/edit");
		edit.addObject("resource", Resource);
		return edit;
	}

	/**
	 * Edit Resource
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("resource") Resource Resource) {
		ModelAndView edit = new ModelAndView();
		Resource ResourceInDB = resourceService.getResourceById(id);
		if (ResourceInDB == null) {
			edit.addObject("errors", "Invalid Resource type!");
			edit.setViewName("redirect:/Resources");
			return edit;
		}
		resourceService.saveResource(Resource);
		edit.setViewName("resource/view");
		edit.addObject("resource", Resource);
		return edit;
	}

	/**
	 * Delete Resource page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/resources");
		Resource Resource = resourceService.getResourceById(id);
		if (Resource == null) {
			edit.addObject("errors", "Invalid Resource type!");
			return edit;
		}
		resourceService.deleteResourceById(id);
		return edit;
	}

}

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

import com.synnex.saas.platform.domain.Code;
import com.synnex.saas.platform.service.ICodeService;

/**
 * Controller for code maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class CodeController {

	@Autowired
	private ICodeService codeService;

	/**
	 * List all codes page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codes", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("code/list");
		Page<Code> allCodes = codeService.getAllCodes(pageable);
		index.addObject("results", allCodes);
		return index;
	}

	/**
	 * Create code page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codes/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("code/create");
		return create;
	}

	/**
	 * Create code page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("code") Code code) {
		ModelAndView save = new ModelAndView();
		codeService.saveCode(code);
		save.setViewName("redirect:/codes");
		return save;
	}

	/**
	 * View code page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/code/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Code code = codeService.getCodeById(id);
		if (code == null) {
			code = new Code();
		}
		view.setViewName("code/view");
		view.addObject("code", code);
		return view;
	}

	/**
	 * Edit code page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/code/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Code code = codeService.getCodeById(id);
		if (code == null) {
			edit.addObject("errors", "Invalid code type!");
			edit.setViewName("redirect:/codes");
			return edit;
		}
		edit.setViewName("code/edit");
		edit.addObject("code", code);
		return edit;
	}

	/**
	 * Edit code
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/code/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("code") Code code) {
		ModelAndView edit = new ModelAndView();
		Code codeInDB = codeService.getCodeById(id);
		if (codeInDB == null) {
			edit.addObject("errors", "Invalid code!");
			edit.setViewName("redirect:/codes");
			return edit;
		}
		codeService.saveCode(code);
		edit.setViewName("code/view");
		edit.addObject("code", code);
		return edit;
	}

	/**
	 * Delete code page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/code/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/codes");
		Code code = codeService.getCodeById(id);
		if (code == null) {
			edit.addObject("errors", "Invalid code type!");
			return edit;
		}
		codeService.deleteCodeById(id);
		return edit;
	}

}

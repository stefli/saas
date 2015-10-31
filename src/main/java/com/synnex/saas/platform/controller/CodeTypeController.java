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

import com.synnex.saas.platform.domain.CodeType;
import com.synnex.saas.platform.service.ICodeTypeService;

/**
 * Controller for CodeType maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class CodeTypeController {

	@Autowired
	private ICodeTypeService codeTypeService;

	/**
	 * List all CodeTypes page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeTypes", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("codeType/list");
		Page<CodeType> page = codeTypeService.getAllCodeTypes(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create CodeType page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeTypes/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("codeType/create");
		return create;
	}

	/**
	 * Create CodeType page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeType", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("codeType") CodeType codeType) {
		ModelAndView save = new ModelAndView();
		codeTypeService.saveCodeType(codeType);
		save.setViewName("redirect:/codeTypes");
		return save;
	}

	/**
	 * View CodeType page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeType/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		CodeType CodeType = codeTypeService.getCodeTypeById(id);
		if (CodeType == null) {
			CodeType = new CodeType();
		}
		view.setViewName("codeType/view");
		view.addObject("codeType", CodeType);
		return view;
	}

	/**
	 * Edit CodeType page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeType/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		CodeType CodeType = codeTypeService.getCodeTypeById(id);
		if (CodeType == null) {
			edit.addObject("errors", "Invalid CodeType type!");
			edit.setViewName("redirect:/codeTypes");
			return edit;
		}
		edit.setViewName("codeType/edit");
		edit.addObject("codeType", CodeType);
		return edit;
	}

	/**
	 * Edit CodeType
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeType/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("codeType") CodeType CodeType) {
		ModelAndView edit = new ModelAndView();
		CodeType CodeTypeInDB = codeTypeService.getCodeTypeById(id);
		if (CodeTypeInDB == null) {
			edit.addObject("errors", "Invalid CodeType type!");
			edit.setViewName("redirect:/CodeTypes");
			return edit;
		}
		codeTypeService.saveCodeType(CodeType);
		edit.setViewName("codeType/view");
		edit.addObject("codeType", CodeType);
		return edit;
	}

	/**
	 * Delete CodeType page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/codeType/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/codeTypes");
		CodeType CodeType = codeTypeService.getCodeTypeById(id);
		if (CodeType == null) {
			edit.addObject("errors", "Invalid CodeType type!");
			return edit;
		}
		codeTypeService.deleteCodeTypeById(id);
		return edit;
	}

}

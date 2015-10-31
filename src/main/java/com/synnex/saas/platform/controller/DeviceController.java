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

import com.synnex.saas.platform.domain.Device;
import com.synnex.saas.platform.service.IDeviceService;

/**
 * Controller for Device maintenance
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:31:08
 */
@Controller
public class DeviceController {

	@Autowired
	private IDeviceService deviceService;

	/**
	 * List all Devices page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public ModelAndView index(Pageable pageable) {
		ModelAndView index = new ModelAndView();
		index.setViewName("device/list");
		Page<Device> page = deviceService.getAllDevices(pageable);
		index.addObject("results", page);
		return index;
	}

	/**
	 * Create Device page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/devices/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView create = new ModelAndView();
		create.setViewName("device/create");
		return create;
	}

	/**
	 * Create Device page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/device", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("device") Device device) {
		ModelAndView save = new ModelAndView();
		deviceService.saveDevice(device);
		save.setViewName("redirect:/devices");
		return save;
	}

	/**
	 * View Device page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView view = new ModelAndView();
		Device Device = deviceService.getDeviceById(id);
		if (Device == null) {
			Device = new Device();
		}
		view.setViewName("device/view");
		view.addObject("device", Device);
		return view;
	}

	/**
	 * Edit Device page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/device/{id}/edit", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		Device Device = deviceService.getDeviceById(id);
		if (Device == null) {
			edit.addObject("errors", "Invalid Device type!");
			edit.setViewName("redirect:/devices");
			return edit;
		}
		edit.setViewName("device/edit");
		edit.addObject("device", Device);
		return edit;
	}

	/**
	 * Edit Device
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/device/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(@PathVariable Long id, @ModelAttribute("device") Device Device) {
		ModelAndView edit = new ModelAndView();
		Device DeviceInDB = deviceService.getDeviceById(id);
		if (DeviceInDB == null) {
			edit.addObject("errors", "Invalid Device type!");
			edit.setViewName("redirect:/Devices");
			return edit;
		}
		deviceService.saveDevice(Device);
		edit.setViewName("device/view");
		edit.addObject("device", Device);
		return edit;
	}

	/**
	 * Delete Device page
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/device/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView edit = new ModelAndView();
		edit.setViewName("redirect:/devices");
		Device Device = deviceService.getDeviceById(id);
		if (Device == null) {
			edit.addObject("errors", "Invalid Device type!");
			return edit;
		}
		deviceService.deleteDeviceById(id);
		return edit;
	}

}

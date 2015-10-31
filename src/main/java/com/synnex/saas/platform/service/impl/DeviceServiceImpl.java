package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Device;
import com.synnex.saas.platform.repository.IDeviceRepository;
import com.synnex.saas.platform.service.IDeviceService;

@Service("deviceService")
@Transactional(readOnly = true)
public class DeviceServiceImpl implements IDeviceService {

	@Autowired
	private IDeviceRepository deviceRepository;

	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	public Page<Device> getAllDevices(Pageable pageable) {
		return deviceRepository.findAll(pageable);
	}

	/**
	 * Create new device
	 */
	@Transactional
	public void saveDevice(Device device) {
		deviceRepository.save(device);
	}

	public Device getDeviceById(Long id) {
		return deviceRepository.getOne(id);
	}

	@Transactional
	public void deleteDeviceById(Long id) {
		deviceRepository.delete(id);
	}

}

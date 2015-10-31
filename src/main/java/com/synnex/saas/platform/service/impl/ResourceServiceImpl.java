package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Resource;
import com.synnex.saas.platform.repository.IResourceRepository;
import com.synnex.saas.platform.service.IResourceService;

@Service("resourceService")
@Transactional(readOnly = true)
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private IResourceRepository resourceRepository;

	public List<Resource> getAllResources() {
		return resourceRepository.findAll();
	}

	public Page<Resource> getAllResources(Pageable pageable) {
		return resourceRepository.findAll(pageable);
	}

	/**
	 * Create new resource
	 */
	@Transactional
	public void saveResource(Resource resource) {
		resourceRepository.save(resource);
	}

	public Resource getResourceById(Long id) {
		return resourceRepository.getOne(id);
	}

	@Transactional
	public void deleteResourceById(Long id) {
		resourceRepository.delete(id);
	}

}

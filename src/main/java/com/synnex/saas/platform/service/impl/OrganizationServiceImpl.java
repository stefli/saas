package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Organization;
import com.synnex.saas.platform.repository.IOrganizationRepository;
import com.synnex.saas.platform.service.IOrganizationService;

@Service("organizationService")
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	private IOrganizationRepository organizationRepository;

	public List<Organization> getAllOrganizations() {
		return organizationRepository.findAll();
	}

	public Page<Organization> getAllOrganizations(Pageable pageable) {
		return organizationRepository.findAll(pageable);
	}

	/**
	 * Create new organization
	 */
	@Transactional
	public void saveOrganization(Organization organization) {
		organizationRepository.save(organization);
	}

	public Organization getOrganizationById(Long id) {
		return organizationRepository.getOne(id);
	}

	@Transactional
	public void deleteOrganizationById(Long id) {
		organizationRepository.delete(id);
	}

}

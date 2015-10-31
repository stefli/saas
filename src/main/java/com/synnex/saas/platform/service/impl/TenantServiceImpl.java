package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Tenant;
import com.synnex.saas.platform.repository.ITenantRepository;
import com.synnex.saas.platform.service.ITenantService;

@Service("tenantService")
@Transactional(readOnly = true)
public class TenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantRepository tenantRepository;

	public Tenant getTenantByHost(String host) {
		return tenantRepository.findByHost(host);
	}

	public List<Tenant> getAllTenants() {
		return tenantRepository.findAll();
	}

	public Page<Tenant> getAllTenants(Pageable pageable) {
		return tenantRepository.findAll(pageable);
	}

	/**
	 * Create new tenant
	 */
	@Transactional
	public void saveTenant(Tenant tenant) {
		tenantRepository.save(tenant);
	}

	public Tenant getTenantById(Long id) {
		return tenantRepository.getOne(id);
	}

	@Transactional
	public void deleteTenantById(Long id) {
		tenantRepository.delete(id);
	}

}

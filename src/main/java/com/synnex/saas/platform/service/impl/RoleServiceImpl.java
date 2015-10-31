package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Role;
import com.synnex.saas.platform.repository.IRoleRepository;
import com.synnex.saas.platform.service.IRoleService;

@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Page<Role> getAllRoles(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	/**
	 * Create new role
	 */
	@Transactional
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	public Role getRoleById(Long id) {
		return roleRepository.getOne(id);
	}

	@Transactional
	public void deleteRoleById(Long id) {
		roleRepository.delete(id);
	}

}

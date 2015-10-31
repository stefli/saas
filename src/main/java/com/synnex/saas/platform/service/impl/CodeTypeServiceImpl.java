package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.CodeType;
import com.synnex.saas.platform.repository.ICodeTypeRepository;
import com.synnex.saas.platform.service.ICodeTypeService;

@Service("codeTypeService")
@Transactional(readOnly = true)
public class CodeTypeServiceImpl implements ICodeTypeService {

	@Autowired
	private ICodeTypeRepository codeTypeRepository;

	/**
	 * Retrieve all codeType
	 */
	public List<CodeType> getAllCodeTypes() {
		return codeTypeRepository.findAll();
	}

	/**
	 * Create new codeType
	 */
	@Transactional
	public void createCodeType(CodeType codeType) {
		codeTypeRepository.save(codeType);
	}

	public CodeType getCodeTypeById(Long id) {
		return codeTypeRepository.getOne(id);
	}

	@Transactional
	public void deleteCodeTypeById(Long id) {
		codeTypeRepository.delete(id);
	}

	@Transactional
	public void saveCodeType(CodeType codeType) {
		codeTypeRepository.save(codeType);
	}

	public Page<CodeType> getAllCodeTypes(Pageable pageable) {
		return codeTypeRepository.findAll(pageable);
	}

}

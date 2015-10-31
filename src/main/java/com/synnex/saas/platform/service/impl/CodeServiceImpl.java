package com.synnex.saas.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synnex.saas.platform.domain.Code;
import com.synnex.saas.platform.repository.ICodeRepository;
import com.synnex.saas.platform.service.ICodeService;

@Service("codeService")
@Transactional(readOnly = true)
public class CodeServiceImpl implements ICodeService {

	@Autowired
	private ICodeRepository codeRepository;

	/**
	 * Retrieve all code
	 */
	public List<Code> getAllCodes() {
		return codeRepository.findAll();
	}

	/**
	 * Create new code
	 */
	@Transactional
	public void createCode(Code code) {
		codeRepository.save(code);
	}

	public Code getCodeById(Long id) {
		return codeRepository.getOne(id);
	}

	@Transactional
	public void deleteCodeById(Long id) {
		codeRepository.delete(id);
	}

	@Transactional
	public void saveCode(Code code) {
		codeRepository.save(code);
	}

	public Page<Code> getAllCodes(Pageable pageable) {
		return codeRepository.findAll(pageable);
	}

}

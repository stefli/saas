package com.synnex.saas.platform.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.synnex.saas.platform.domain.Code;

public interface ICodeService {

	List<Code> getAllCodes();

	Code getCodeById(Long id);

	void deleteCodeById(Long id);

	void saveCode(Code code);

	Page<Code> getAllCodes(Pageable pageable);

}

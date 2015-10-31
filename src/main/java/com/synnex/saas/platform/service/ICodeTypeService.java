package com.synnex.saas.platform.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.synnex.saas.platform.domain.CodeType;

public interface ICodeTypeService {

	List<CodeType> getAllCodeTypes();

	CodeType getCodeTypeById(Long id);

	void deleteCodeTypeById(Long id);

	void saveCodeType(CodeType codeType);

	Page<CodeType> getAllCodeTypes(Pageable pageable);

}

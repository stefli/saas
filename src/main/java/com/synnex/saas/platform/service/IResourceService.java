/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.synnex.saas.platform.domain.Resource;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-25 下午3:21:46
 */
public interface IResourceService {

	List<Resource> getAllResources();

	Page<Resource> getAllResources(Pageable pageable);

	Resource getResourceById(Long id);

	void deleteResourceById(Long id);

	void saveResource(Resource resource);

}

/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.core.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.synnex.saas.platform.domain.Tenant;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-25 下午3:42:46
 */
public class CacheManager {

	private static final Map<String, Tenant> TENANT_CACHE = new ConcurrentHashMap<String, Tenant>();

	private static CacheManager instance = new CacheManager();

	private CacheManager() {
	}

	public static synchronized CacheManager getInstance() {
		return instance;
	}

	public static synchronized void cacheAllTenants(List<Tenant> tenantList) {
		int size = tenantList.size();
		Tenant tenant = null;
		for (int i = 0; i < size; i++) {
			tenant = tenantList.get(i);
			if (StringUtils.isNotBlank(tenant.getHost())) {
				TENANT_CACHE.put(tenant.getHost(), tenant);
			}
		}
	}

	public static Map<String, Tenant> getAllTenants() {
		return TENANT_CACHE;
	}

	/**
	 * @param host
	 * @return tenant
	 * 
	 */
	public Tenant getTenantByHost(String host) {
		if (StringUtils.isNotBlank(host)) {
			return TENANT_CACHE.get(host);
		}
		return null;
	}

}

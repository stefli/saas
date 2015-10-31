/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.core.session.SessionManager;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-26 上午9:20:49
 */
public class TenantUtils {

	private TenantUtils() {
	}

	public static Map<String, String> initEMFProperties(String tenantKey) {
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("tenant_id", tenantKey);
		properties.put("eclipselink.session-name", "multi-tenant-" + tenantKey);
		return properties;
	}

	public static void prepareTenantEntityManager(EntityManager em) {
		Map<String, Object> properties = SessionManager.getEMFProperties();
		if (properties == null || properties.isEmpty()) {
			return;
		}
		EntityManagerImpl emDelegate = (EntityManagerImpl) em.getDelegate();
		emDelegate.setProperties(properties);
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME,
				SessionManager.getEMFProperties());
		return factory.createEntityManager();
	}

}

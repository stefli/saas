/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.core.jpa;

import java.util.Map;

import org.springframework.orm.jpa.JpaTransactionManager;

import com.synnex.saas.platform.core.session.SessionManager;

/**
 * 
 * @author stevenl
 * @datetime 2015-4-3 下午4:05:43
 */
public class MultiTenantJpaTransactionManager extends JpaTransactionManager {

	private static final long serialVersionUID = 8460951587603986264L;

	/**
	 * NOTE: Maybe it would be also possible to replace existing entityManager
	 * in transaction with new but it isn't a good idea because of rollback and
	 * other problems. So when new tenant is required always start new
	 * transaction for it.
	 */

	@Override
	public Map<String, Object> getJpaPropertyMap() {
		Map<String, Object> superProperties = super.getJpaPropertyMap();
		System.out.println("##############Class ID:" + superProperties.getClass());
		Map<String, Object> tenantProperties = SessionManager.getEMFProperties();
		if (tenantProperties != null && !tenantProperties.isEmpty()) {
			superProperties.putAll(tenantProperties);
		}
		return superProperties;
	}

}

/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.core;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.synnex.saas.platform.domain.Code;
import com.synnex.saas.platform.domain.Tenant;
import com.synnex.saas.platform.domain.User;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-25 下午5:01:14
 */
@Component
public class Startup {

	@PersistenceContext
	private EntityManager em;

	@PersistenceContext
	private EntityManager emTenant;

	@Resource
	private PlatformTransactionManager transactionManager;

	@PostConstruct
	public void addSampleData() {
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 3; i++) {
			TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
			String tenantId = UUID.randomUUID().toString();
			Tenant tenant = new Tenant();
			tenant.setHost("t" + (i + 1) + ".synnex.com:8085");
			tenant.setName("Tenant-" + (i + 1));
			cal.add(Calendar.DAY_OF_YEAR, 100);
			tenant.setRegisterDate(new Timestamp(System.currentTimeMillis()));
			tenant.setExpiredDate(new Timestamp(cal.getTimeInMillis()));
			tenant.setTenantId(tenantId);
			// Create sample users
			for (int j = 0; j < 10; j++) {
				// User
				TransactionStatus txTenant = transactionManager.getTransaction(new DefaultTransactionDefinition());
				emTenant.setProperty("tenant_id", tenantId);
				emTenant.setProperty("eclipselink.session-name", "multi-tenant-" + tenantId);
				User user = new User();
				user.setUserName("t" + (j + 1));
				user.setNickName("Steven Li");
				MessageDigestPasswordEncoder digest = new MessageDigestPasswordEncoder("md5");
				user.setPassword(digest.encodePassword("password", "123"));
				user.setEnabled(true);
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, 10);
				user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
				user.setExpiredDate(new Timestamp(cal.getTimeInMillis()));
				emTenant.persist(user);
				transactionManager.commit(txTenant);
			}

			// Create sample code
			for (int j = 0; j < 200; j++) {
				// User
				TransactionStatus txTenant = transactionManager.getTransaction(new DefaultTransactionDefinition());
				emTenant.setProperty("tenant_id", tenantId);
				emTenant.setProperty("eclipselink.session-name", "multi-tenant-" + tenantId);

				// Code
				Code code = new Code();
				code.setName("SSSS");
				emTenant.persist(code);
				transactionManager.commit(txTenant);
			}
			em.persist(tenant);
			transactionManager.commit(tx);
		}
	}
}

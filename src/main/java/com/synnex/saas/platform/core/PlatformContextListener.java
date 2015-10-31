package com.synnex.saas.platform.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.synnex.saas.platform.core.cache.CacheManager;
import com.synnex.saas.platform.service.ITenantService;

public class PlatformContextListener implements ServletContextListener {

	private final static Logger logger = LoggerFactory.getLogger(PlatformContextListener.class);

	private ServletContext context;

	@Autowired
	private ITenantService tenantService;

	public void contextDestroyed(ServletContextEvent event) {
		context = event.getServletContext();
	}

	/**
	 * Cache all necessary informations, such as Dictionary/Tenants, and so on
	 * 
	 */
	public void contextInitialized(ServletContextEvent event) {
		context = event.getServletContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(context).getAutowireCapableBeanFactory()
				.autowireBean(this);
		logger.info("Start to cache all tenants!");
		CacheManager.cacheAllTenants(tenantService.getAllTenants());
		logger.info("Finished to cache all tenants!");
	}

}

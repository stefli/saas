package com.synnex.saas.platform.core;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.synnex.saas.platform.constants.Constants;
import com.synnex.saas.platform.core.cache.CacheManager;
import com.synnex.saas.platform.domain.Tenant;

public class TenantFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tenantKey = "UNDEFINED";
		String host = request.getHeader("Host");
		if (StringUtils.isNotBlank(host)) {
			CacheManager cacheManager = CacheManager.getInstance();
			Tenant tenant = cacheManager.getTenantByHost(host);
			if (tenant != null) {
				tenantKey = tenant.getTenantId();
				if (StringUtils.isBlank(tenantKey)) {
					response.sendError(404);
				}
			}
		}
		request.setAttribute(Constants.TENANT_KEY, tenantKey);
		filterChain.doFilter(request, response);
	}

}

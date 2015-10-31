package com.synnex.saas.platform.core.session;

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper of user session
 * 
 * @author stevenl
 * @datetime 2015-2-25 下午3:04:39
 */
public class SessionContext {

	private Map<String, Object> attributes = new HashMap<String, Object>();

	public Object getContextValue(String key) {
		return attributes.get(key);
	}

	public void setContextValue(String key, Object value) {
		attributes.put(key, value);
	}

}

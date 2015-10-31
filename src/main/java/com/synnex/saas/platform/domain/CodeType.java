package com.synnex.saas.platform.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import com.synnex.saas.platform.constants.Constants;

@Entity
@Table(name = "plat_code_type")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", contextProperty = Constants.TENANT_CONTEXT_PROPERTY, length = 36)
public class CodeType extends BaseEntity {

	private static final long serialVersionUID = 489716715518594255L;

	private String name;

	private String descr;

	private int version = 0;

	@Transient
	private Map<String, Object> extensions = new HashMap<String, Object>();

	@Version
	@Column(name = "OPTLOCK")
	public int getVersion() {
		return this.version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) extensions.get(name);
	}

	public Object set(String name, Object value) {
		return extensions.put(name, value);
	}

	public Map<String, Object> getExtensions() {
		return extensions;
	}

}

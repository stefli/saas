package com.synnex.saas.platform.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import com.synnex.saas.platform.constants.Constants;

@Entity
@Table(name = "plat_device")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", contextProperty = Constants.TENANT_CONTEXT_PROPERTY, length = 36)
public class Device extends BaseEntity {

	private static final long serialVersionUID = 8130955156267041249L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

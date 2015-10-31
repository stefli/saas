package com.synnex.saas.platform.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import com.synnex.saas.platform.constants.Constants;

@Entity
@Table(name = "plat_role")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", contextProperty = Constants.TENANT_CONTEXT_PROPERTY, length = 36)
public class Role extends BaseEntity {

	private static final long serialVersionUID = 5074799723532148167L;

	private String name;

	private String descr;

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

}

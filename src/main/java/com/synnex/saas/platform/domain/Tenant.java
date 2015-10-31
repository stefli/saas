package com.synnex.saas.platform.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "plat_tenant")
public class Tenant extends BaseEntity {

	private static final long serialVersionUID = 4323791210106039407L;

	private String name;

	private String host;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiredDate;

	@Column(name = "TENANT_ID")
	private String tenantId;

	public Tenant() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}

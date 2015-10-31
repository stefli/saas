package com.synnex.saas.platform.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import com.synnex.saas.platform.constants.Constants;

@Entity
@Table(name = "plat_user_attempts")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", contextProperty = Constants.TENANT_CONTEXT_PROPERTY, length = 36)
public class UserAttempts extends BaseEntity {

	private static final long serialVersionUID = 1644470940874174691L;

	private String userName;

	private int attempts;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DT")
	private Date lastModifiedDt;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModifiedDt() {
		return lastModifiedDt;
	}

	public void setLastModifiedDt(Date lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

}

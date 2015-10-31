package com.synnex.saas.platform.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.synnex.saas.platform.constants.Constants;

@Entity
@Table(name = "plat_user")
@Multitenant
@TenantDiscriminatorColumn(name = "TENANT_ID", contextProperty = Constants.TENANT_CONTEXT_PROPERTY, length = 36)
public class User extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 7371854286155345639L;

	private String userName;

	private String nickName;

	private String password;

	private String salt = "123";

	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiredDate;

	private boolean locked = false;

	private boolean enabled = false;

	@Transient
	private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public User() {
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getUsername() {
		return this.userName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isAccountNonExpired() {
		return this.expiredDate.after(new Date());
	}

	public boolean isAccountNonLocked() {
		return !this.locked;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}

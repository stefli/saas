/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-27 上午9:50:04
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CREATE_ID")
	private Long createId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DT")
	private Date createDt;

	@Column(name = "UPDATE_ID")
	private Long updateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DT")
	private Date updateDt;

	public Long getId() {
		return id;
	}

	public Long getCreateId() {
		return createId;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

}
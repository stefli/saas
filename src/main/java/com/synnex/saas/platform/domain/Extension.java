package com.synnex.saas.platform.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;

@Entity
@Table(name = "plat_extension")
@Multitenant
public class Extension extends BaseEntity {

	private static final long serialVersionUID = -4107248958970213490L;

	private String label;

	private String dataType;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}

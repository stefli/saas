package com.synnex.saas.platform.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "plat_extension_value")
public class ExtensionValue extends BaseEntity {

	private static final long serialVersionUID = 4593941119302119505L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

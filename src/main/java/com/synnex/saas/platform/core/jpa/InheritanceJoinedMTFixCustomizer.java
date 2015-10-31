/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.core.jpa;

import org.eclipse.persistence.annotations.TenantTableDiscriminatorType;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.TablePerMultitenantPolicy;

/**
 * 
 * @author stevenl
 * @datetime 2015-4-3 下午4:06:25
 */
public class InheritanceJoinedMTFixCustomizer implements DescriptorCustomizer {

	public void customize(ClassDescriptor descriptor) throws Exception {
		((TablePerMultitenantPolicy) descriptor.getMultitenantPolicy())
				.setTenantTableDiscriminatorType(TenantTableDiscriminatorType.SCHEMA);
	}

}

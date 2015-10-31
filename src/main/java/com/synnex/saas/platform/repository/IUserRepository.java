/******************************************************************************
 * @Copyright Notice: 
 * Copyright (c) 2012 SYNNEX Corporation. All  Rights Reserved.
 * This software is published under the terms of the SYNNEX Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 *****************************************************************************/
package com.synnex.saas.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synnex.saas.platform.domain.User;

/**
 * 
 * @author stevenl
 * @datetime 2015-2-26 下午2:56:20
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	User getUserByUserName(String userName);

}

package com.hc.scm.uc.purchasing.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hc.scm.common.base.dal.BaseCrudDao;
import com.hc.scm.common.base.service.BaseCrudServiceImpl;
import com.hc.scm.uc.dal.purchasing.dao.HcSupplierContactsManagementDao;
import com.hc.scm.uc.purchasing.service.HcSupplierContactsManagementService;

/**
 * Description: 请写出类的用途
 * All rights Reserved, Designed Byhcopyright:   Copyright(C) 2016-2017
 * Company:     hc.
 * @author:     jinxi.li
 * @date:  2016年8月21日
 * @version 1.0.0
 */

@Service("hcSupplierContactsManagementService")
public class HcSupplierContactsManagementServiceImpl extends BaseCrudServiceImpl implements HcSupplierContactsManagementService {
	@Resource
	private HcSupplierContactsManagementDao  hcSupplierContactsManagementDao;
	
	@Override
	public BaseCrudDao init() {
		// TODO Auto-generated method stub
		return hcSupplierContactsManagementDao;
	}


}

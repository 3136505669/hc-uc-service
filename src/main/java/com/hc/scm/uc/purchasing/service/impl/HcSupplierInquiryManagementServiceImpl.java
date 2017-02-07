package com.hc.scm.uc.purchasing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.hc.scm.common.base.dal.BaseCrudDao;
import com.hc.scm.common.base.service.BaseCrudServiceImpl;
import com.hc.scm.common.exception.DaoException;
import com.hc.scm.common.exception.ServiceException;
import com.hc.scm.common.model.SystemUser;

import com.hc.scm.uc.dal.purchasing.dao.HcSupplierInquiryManagementDao;

import com.hc.scm.uc.purchasing.service.HcSupplierInquiryManagementService;

/**
 * Description: 请写出类的用途
 * All rights Reserved, Designed Byhcopyright:   Copyright(C) 2016-2017
 * Company:     hc.
 * @author:     jinxi.li
 * @date:  2016年8月21日
 * @version 1.0.0
 */

@Service("hcSupplierInquiryManagementService")
public class HcSupplierInquiryManagementServiceImpl extends BaseCrudServiceImpl implements HcSupplierInquiryManagementService {
	@Resource
	private HcSupplierInquiryManagementDao  hcSupplierInquiryManagementDao;
	
	@Override
	public BaseCrudDao init() {
		// TODO Auto-generated method stub
		return hcSupplierInquiryManagementDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
	public <ModelType, ModelCustomerType> void deleteMasterCustomer(
			List<ModelType> listModelCustomerType,
			Class<ModelCustomerType> customerClazz, String idFieldName,
			String customerName, SystemUser systemUser) throws DaoException{
		  System.out.println(listModelCustomerType.size());
		 for(Object obj:listModelCustomerType){
			 //{"pageSize":"25","contactsNo":"C016200611154453","_dc":"1478766586874","pageNum":"1","contactsName":"李金洗"}
			   Map<String, Object> params=new HashMap<String,Object>();

			    params.put(idFieldName, JSONObject.parseObject(JSONObject.toJSONString(obj).toString()).getString(idFieldName));
	
		        List<ModelCustomerType> list = (List<ModelCustomerType>) this.hcSupplierInquiryManagementDao.findByBiz(customerClazz, params);
	             for(ModelCustomerType  pobj:list){
	            	 System.out.println(pobj.getClass().getName());
	            	 this.hcSupplierInquiryManagementDao.deleteSubById(pobj);
	            	 System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	             }
	             System.out.println(obj.getClass().getName());
	             this.hcSupplierInquiryManagementDao.deleteById(obj);
		        System.out.println(list.size());
		 }
		
	}

	
	

	


	



}

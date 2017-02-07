package com.hc.scm.uc.file.json.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.scm.common.base.dal.BaseCrudDao;
import com.hc.scm.common.base.service.BaseCrudServiceImpl;
import com.hc.scm.uc.dao.file.json.model.City;
import com.hc.scm.uc.file.json.service.FileToJsonCityService;


@Service("fileToJsonCityService")
public class FileToJsonCityServiceImpl extends BaseCrudServiceImpl implements FileToJsonCityService {

	@Override
	public List<City> getCityList(String provinceNo) {
		String fullFileName = "E:\\hcconf\\scm\\hc-uc\\json\\city.json";
	    List<City>  list=new ArrayList<City>();
    	File file = new File(fullFileName);
    	Scanner scanner = null;
    	StringBuilder buffer = new StringBuilder();
    	try {
    	    scanner = new Scanner(file, "utf-8");
    	    while (scanner.hasNextLine()) {
    	        buffer.append(scanner.nextLine());
    	    }

    	} catch (FileNotFoundException e) {
    	} finally {
    	    if (scanner != null) {
    	        scanner.close();
    	    }
    	}
    	 ObjectMapper oMapper = new ObjectMapper();
    	 City[]  p=null;
    	 try {
             p = oMapper.readValue(buffer.toString(), City[].class);
         } catch (Exception e) {
             e.printStackTrace();
         } 
    	 for(int i=0;i<p.length;i++){
    		 if(provinceNo!=null&&!"".equals(provinceNo)){
    			 if(provinceNo.equals(p[i].getProvinceNo().toString())){
        			 list.add(p[i]); 
        		 } 
    		 }
    		
    		 
    	 }
		return list;
	}

	@Override
	public BaseCrudDao init() {
		// TODO Auto-generated method stub
		return null;
	}

}

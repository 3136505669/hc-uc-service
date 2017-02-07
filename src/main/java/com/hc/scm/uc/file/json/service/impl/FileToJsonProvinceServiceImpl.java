package com.hc.scm.uc.file.json.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.scm.common.base.dal.BaseCrudDao;
import com.hc.scm.common.base.service.BaseCrudServiceImpl;
import com.hc.scm.uc.dao.file.json.model.Province;
import com.hc.scm.uc.file.json.service.FileToJsonProvinceService;


@Service("fileToJsonProvinceService")
public class FileToJsonProvinceServiceImpl extends BaseCrudServiceImpl implements FileToJsonProvinceService {

	@Override
	public BaseCrudDao init() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Province> getProvinceList() {
		String fullFileName = "E:\\hcconf\\scm\\hc-uc\\json\\provinces.json";
	    List<Province>  list=new ArrayList<Province>();
    	File file = new File(fullFileName);
    	Scanner scanner = null;
    	StringBuilder buffer = new StringBuilder();
    	try {
    	    scanner = new Scanner(file, "utf-8");
    	    while (scanner.hasNextLine()) {
    	        buffer.append(scanner.nextLine());
    	    }

    	} catch (FileNotFoundException e) {
    	    // TODO Auto-generated catch block  

    	} finally {
    	    if (scanner != null) {
    	        scanner.close();
    	    }
    	}
    	 ObjectMapper oMapper = new ObjectMapper();
    	 Province[]  p=null;
    	 try {
             p = oMapper.readValue(buffer.toString(), Province[].class);
         } catch (Exception e) {
             e.printStackTrace();
         } 
    	 for(int i=0;i<p.length;i++){
    		 list.add(p[i]);
    	 }
		return list;
	}

}

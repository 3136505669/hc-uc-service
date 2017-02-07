package com.hc.scm.uc.file.json.service;

import java.util.List;

import com.hc.scm.common.base.service.BaseCrudService;
import com.hc.scm.uc.dao.file.json.model.Province;

public interface FileToJsonProvinceService extends BaseCrudService {
   public  List<Province>   getProvinceList();
}

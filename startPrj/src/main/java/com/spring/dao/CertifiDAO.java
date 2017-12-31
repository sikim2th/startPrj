package com.spring.dao;

import java.util.Map;

public interface CertifiDAO {
	
	public void deleteTempKey(String phone);
	
	public void insertCertificationKey(Map<Object,Object> param);
	
	public String getTempKey(String phone);

}

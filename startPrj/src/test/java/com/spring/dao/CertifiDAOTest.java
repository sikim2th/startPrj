package com.spring.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.CertifiDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class CertifiDAOTest {
	
	@Inject
	private CertifiDAO certifiDAO;
	
	@Test
	public void testGetTempKey() throws Exception{
		
		String phone = "010-1111-2222";
		System.out.println(certifiDAO.getTempKey(phone));
	}
	
//	@Test
	public void testInsertCertificationKey() throws Exception{
		
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("phone", "010-6294-4123");
		param.put("tempKey", "999999");
		
		certifiDAO.insertCertificationKey(param);
		
	}

}

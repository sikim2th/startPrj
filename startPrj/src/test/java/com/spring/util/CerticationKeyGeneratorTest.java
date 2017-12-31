package com.spring.util;

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
public class CerticationKeyGeneratorTest {
	
	@Inject
	private CertifiDAO certifiDAO;
	
	CertificationKeyGenerator keyGenerator = CertificationKeyGenerator.newInstance();
	
	@Test
	public void testTempKeyGenarator() throws Exception{
		
		String phone = "010-1111-2222";
		
		keyGenerator.tempKeyGenerator(certifiDAO, phone);
		
	}
	
//	@Test
	public void testisCorrectCertifiKey() throws Exception{
		
		String phone = "010-1111-2222";
		String inputKey = "658600";
		
		if(keyGenerator.isCorrectCertifiKey(certifiDAO, phone, inputKey)){
			System.out.println("succ");
		}else{
			System.out.println("fail");
		}
		
	}

}

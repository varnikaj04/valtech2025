package com.valtech.training.restApis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.restApis.vos.OwnerVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestApisApplicationTests {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getOwnerWithId() throws Exception {

		int id = 1;
		String url = "http://localhost:" +port+"/api/v1/owners/" +id;
		OwnerVO owner = restTemplate.getForObject(url, OwnerVO.class);
		System.out.println(owner);
	}

}

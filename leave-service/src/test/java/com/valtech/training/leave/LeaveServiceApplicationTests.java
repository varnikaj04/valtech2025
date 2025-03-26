package com.valtech.training.leave;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.vos.LeaveMasterVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveServiceApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void createLeaveMastersTest() {
		String baseurl = "http://localhost:" +port+"/api/v1/leaveMasters/";
		List leaveMasters = restTemplate.getForObject(baseurl, List.class);
		if(leaveMasters.size() == 0) {
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 5, 5, 5, 1), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 4, 4, 4, 2), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 3, 3, 3, 3), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 3, 3, 3, 4), LeaveMasterVO.class);
			restTemplate.postForObject(baseurl, new LeaveMasterVO(0, 3, 3, 3, 5), LeaveMasterVO.class);
		}
	}

}

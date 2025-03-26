package com.valtech.training.springsecurityjwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityJwtApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithAnonymousUser
	void testHelloWithAnonymous() throws Exception {
		mockMvc.perform(get("/hello")).andDo(print())
		.andExpect(content().string("Hello"))
		.andExpect(status().isOk());
	}
	
	@Test
	@WithAnonymousUser
	void testDataWithAnonymous() throws Exception {
		mockMvc.perform(get("/data")).andDo(print())
		.andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithMockUser(roles = "USER")
	void testDataWithValidUser() throws Exception {
		mockMvc.perform(get("/data")).andDo(print())
		.andExpect(content().string("Data"))
		.andExpect(status().isOk());
	}

}

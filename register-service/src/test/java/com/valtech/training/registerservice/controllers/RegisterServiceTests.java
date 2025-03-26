package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.training.registerservice.vos.UserVO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetUserByValidId() throws Exception {
		
		mockMvc.perform(get("/api/v1/users/8")).andDo(print()).andExpect(content()
				.json("{'id': 8, 'name': 'Varnika','mobileNo': '36987856', 'age': 23, 'email': 'avsd@lfdf.com', 'kid': false,'subs_id': 2}"))
		.andExpectAll(status().isOk());
	}
	
	
	
	
}

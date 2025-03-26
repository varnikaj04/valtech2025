package com.valtech.training.questionservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionServiceControllerTest {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addQuestions() {

		List ques = restTemplate.getForObject("http://localhost:" + port + "/api/v1/questions/", List.class);
		if (ques.size() == 0) {
			QuestionVO ques1 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "What is the color of the Sky", "Pink", "Blue", "White", "Red", "Blue", "GK"),QuestionVO.class);
			QuestionVO ques2 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "What is the color of the Moon", "Pink", "Blue", "White", "Red", "White", "GK"),QuestionVO.class);
			QuestionVO ques3 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "What is the color of the Mars", "Pink", "Blue", "White", "Red", "Red", "GK"),QuestionVO.class);
			QuestionVO ques4 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/", 
					new Question(0, "What is the color of the Jupiter", "Pink", "Blue", "Yellow", "Red", "Yellow", "GK"),QuestionVO.class);
			QuestionVO ques5 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "What is the color of the Sun", "Orange", "Blue", "Black", "Red", "Orange", "GK"),QuestionVO.class);
			

			QuestionVO ques6 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "What is the Super class of Exceptions?", "Object", "Exception", "Throwable",
							"Error", "Throwable", "Java"),QuestionVO.class);
			QuestionVO ques7 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "Which class is used to create Dynamic Strings?", "String", "DynamicString",
							"StringBuilder", "Builder", "StringBuilder", "Java"),QuestionVO.class);
			QuestionVO ques8 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "How many methods are there in Marker Interface?", "None", "One", "Two", "Many",
							"None", "Java"),QuestionVO.class);
			QuestionVO ques9 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "How many methods are there in Functional Interface?", "None", "One", "Two", "Many",
							"One", "Java"),QuestionVO.class);
			QuestionVO ques10 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/questions/",
					new Question(0, "Can an Interface have private methods?", "Yes", "No", "Maybe",
							"No methods can be there in an interface", "Yes", "Java"),QuestionVO.class);
		}

	}

}

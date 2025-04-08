package com.valtech.training.quizservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quizservice.vos.QuestionVO;

@Component
public class QuestionClient {
	
	String url = "http://localhost:9090/api/v1/question/";
	
	public List<QuestionVO> getAllQuestionsByTopic(String topic){
		RestTemplate rest = new RestTemplate();
		String url1 = url + "topic/" + topic ;
		List<QuestionVO> ques = Arrays.asList(rest.getForObject(url1,QuestionVO[].class));
		return ques;
	}
	
	public List<QuestionVO> getQuestionsByIds(List<Integer> questionIds) {
		RestTemplate temp = new RestTemplate();
		String url2 = url + "questions/"+questionIds.stream().map(String::valueOf).collect(Collectors.joining(","));
		List<QuestionVO> questions = Arrays.asList(temp.getForObject(url2,QuestionVO[].class));
		return questions;
	}
	
	

}

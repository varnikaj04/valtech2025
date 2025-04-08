package com.valtech.project.resultservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.project.resultservice.vos.QuestionVO;

@Component
public class QuestionClient {

	public List<String> getAnswersFromQuestionIds(List<Long> qids){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9030/api/v1/questions/questions/"+qids.stream().map(String::valueOf).collect(Collectors.joining(","));
		List<QuestionVO> questions = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class));
		List<String> correctAnswers = questions.stream().map(q -> q.answer()).collect(Collectors.toList());
		return correctAnswers;
	}
	
}

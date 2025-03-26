package com.valtech.project.resultservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.project.resultservice.vos.QuizVO;

@Component
public class QuizClient {

	public List<String> getSubmittedAnswers(int id) {

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9080/api/v1/quiz/answers/" + id;
		List<String> answers = restTemplate.getForObject(url, List.class);
		return answers;
	}

	public List<Long> getQuestionIdsFromQuiz(long quizId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9080/api/v1/quiz/" + quizId + "/questions";
		List<QuizVO> vo = Arrays.asList(restTemplate.getForObject(url, QuizVO[].class));
		return vo.stream().map(que -> que.id()).collect(Collectors.toList());
	}

}

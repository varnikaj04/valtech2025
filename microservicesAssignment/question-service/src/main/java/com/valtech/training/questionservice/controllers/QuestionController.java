package com.valtech.training.questionservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.questionservice.services.QuestionService;
import com.valtech.training.questionservice.vos.QuestionVO;


@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@PostMapping("/")
	public QuestionVO addOrUpdateQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.saveOrUpdateQuestion(questionVO);
	}
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") int id) {
		return questionService.getQuestion(id);
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionsByTopic(@PathVariable("topic") String topic) {
		return questionService.getAllQuestionsByTopic(topic);
	}
	
//	@GetMapping("/random/{topic}/{number}")
//	public List<QuestionVO> getRandomQuestionsByTopic(@PathVariable() String topic, int number){
//		return questionService.getRandomQuestionsByTopic(topic, number);
//	}
}

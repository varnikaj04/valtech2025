package com.valtech.training.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.services.QuizService;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public QuizVO createQuiz(@RequestBody QuizVO quiz) {
		return quizService.createQuiz(quiz);
	}
	
	@GetMapping("/")
	public List<QuizVO> getAllQuizes(){
		return quizService.getAllQuizes();
	}
	
	@GetMapping("/{id}")
	public QuizVO getQuizById(@PathVariable(name = "id") long id) {
		return quizService.getQuiz(id);
	}
	@GetMapping("/{topic}/{noOfQuestions}")
	public List<QuestionVO> getQuestions(@PathVariable("topic") String topic, @PathVariable("noOfQuestions") int noOfQuestions){
		return quizService.getQuesByTopicAndNoOfQues(topic, noOfQuestions);
	}
	@GetMapping("/{quizId}/questions")
	public List<QuestionVO> getQuestionsForQuiz(@PathVariable("quizId") int quizId){
		return quizService.getQuestionsByQuiz(quizId);
	}
	@GetMapping("/answers/{id}")
	public List<String> getAnswerById(@PathVariable("id") int id){
		return quizService.getAnswers(id);
	}
	@PostMapping("/takequiz/{quizId}")
	public QuizVO takeQuiz(@PathVariable("quizId") int quizId,@RequestBody List<String> answers) {
		return quizService.takeQuiz(quizId, answers);
	}
	
}

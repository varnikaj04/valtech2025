package com.valtech.training.quizservice.services;

import java.util.List;

import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;

public interface QuizService {

	QuizVO createQuiz(QuizVO quiz);

	QuizVO getQuiz(long id);

	List<QuizVO> getAllQuizes();

	List<QuestionVO> getQuestionsByQuiz(long id);

	List<String> getAnswers(long id);

	QuizVO takeQuiz(long quizId, List<String> answers);

	List<QuestionVO> getQuesByTopicAndNoOfQues(String topic, int noOfQuestions);

	List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions);

}
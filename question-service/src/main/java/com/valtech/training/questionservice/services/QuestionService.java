package com.valtech.training.questionservice.services;

import java.util.List;

import com.valtech.training.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO ques);

	QuestionVO getQuestion(int id);

	List<QuestionVO> getAllQuestions();

	List<QuestionVO> getAllQuestionsByTopic(String topic);

//	List<QuestionVO> getRandomQuestionsByTopic(String topic, int number);

}
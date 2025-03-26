package com.valtech.training.quizservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.quizservice.entities.Quiz;

public record QuizVO(long quizId, int noOfQues, String topic, List<Integer> questionIds, List<String> answers) {

	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getQuizId(), q.getNoOfQues(), q.getTopic(), q.getQuestionIds(), q.getAnswers());
	}
	
	public Quiz to() {
		return new Quiz(noOfQues, topic, questionIds, answers);
	}
	
	public static List<QuizVO> from(List<Quiz> quiz){
		return quiz.stream().map(q -> QuizVO.from(q)).collect(Collectors.toList());
	}
	

	
}

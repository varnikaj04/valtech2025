package com.valtech.training.questionservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.questionservice.entities.Question;

public record QuestionVO(int id, String questionText, String option1, String option2, String option3, String option4, String answer, String topic) {
	
	public static QuestionVO from(Question q) {
		return new QuestionVO(q.getId(), q.getQuestionText(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(),q.getAnswer(),q.getTopic());
	}
	
	public Question to() {
		return new Question(id, questionText, option1, option2, option3, option4, answer, topic);
	}
	
	public static List<QuestionVO> from(List<Question> question){
		return question.stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	

}

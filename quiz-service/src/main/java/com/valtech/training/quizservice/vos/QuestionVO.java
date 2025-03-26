package com.valtech.training.quizservice.vos;

public record QuestionVO(int id, String questionText, String option1, String option2, String option3, String option4, String answer, String topic) {

}

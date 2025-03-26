package com.valtech.project.resultservice.vos;

import java.util.List;

public record QuizVO(long id,int noOfQuestions, String topic, List<Integer> quiestionIds, List<String> answers) {

}

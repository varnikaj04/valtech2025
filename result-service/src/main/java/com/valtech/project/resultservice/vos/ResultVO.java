package com.valtech.project.resultservice.vos;

import com.valtech.project.resultservice.entities.Result;

public record ResultVO(int id, int quizId, int score) {

	public static ResultVO from(Result result) {
		return new ResultVO(result.getId(),result.getQuizId(),result.getScore());
	}
	public Result to() {
		return new Result(id,quizId,score);
	}
	
}

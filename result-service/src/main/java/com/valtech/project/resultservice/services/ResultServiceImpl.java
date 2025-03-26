package com.valtech.project.resultservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.resultservice.entities.Result;
import com.valtech.project.resultservice.repos.ResultRepo;
import com.valtech.project.resultservice.vos.ResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepo resultRepo;

	@Autowired
	private QuizClient quizClient;

	@Autowired
	private QuestionClient questionClient;

	@Override
	public ResultVO testResults(int quizId) {

		List<String> submittedAnswers = quizClient.getSubmittedAnswers(quizId);
		List<Long> qids = quizClient.getQuestionIdsFromQuiz(quizId);
		List<String> rightAnswers = questionClient.getAnswersFromQuestionIds(qids);

		int score = 0;
		for (int i = 0; i < rightAnswers.size(); i++) {
			if (rightAnswers.get(i).equalsIgnoreCase(submittedAnswers.get(i))) {
				score++;
			}

		}

		Result result = new Result();
		result.setQuizId(quizId);
		result.setScore(score);

		return ResultVO.from(resultRepo.save(result));

	}

}

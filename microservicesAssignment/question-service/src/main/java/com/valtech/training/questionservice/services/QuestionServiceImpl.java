package com.valtech.training.questionservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.valtech.training.questionservice.repos.QuestionRepo;
import com.valtech.training.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO ques) {
		return QuestionVO.from(questionRepo.save(ques.to()));
	}
	
	@Override
	public QuestionVO getQuestion(int id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(q -> QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	public List<QuestionVO> getAllQuestionsByTopic(String topic){
		return QuestionVO.from(questionRepo.findAllQuestionsByTopic(topic));
	}

//	@Override
//	public List<QuestionVO> getRandomQuestionsByTopic(String topic, int number) {
//		return QuestionVO.from(questionRepo.findRandomQuestionsByTopic(topic, number));
//	}

	
}

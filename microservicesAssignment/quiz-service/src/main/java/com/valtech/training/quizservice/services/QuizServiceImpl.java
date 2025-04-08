package com.valtech.training.quizservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.Quiz;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionVO;
import com.valtech.training.quizservice.vos.QuizVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public QuizVO createQuiz(QuizVO vo) {
		Quiz quiz = vo.to();
		String topic = quiz.getTopic();
		
		int noOfQuestions = quiz.getNoOfQues();
		List<QuestionVO> allQuestions = questionClient.getAllQuestionsByTopic(topic);
		
		List<Integer> questionIds = getRandomQuestionIds(allQuestions,noOfQuestions);
		quiz.setTopic(topic);
		quiz.setNoOfQues(noOfQuestions);
		quiz.setQuestionIds(questionIds);
		quiz.setAnswers(vo.answers());
		
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);
	}
	
	@Override
	public QuizVO getQuiz(long id) {
		return QuizVO.from(quizRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuizVO> getAllQuizes(){
		return quizRepo.findAll().stream().map(q -> QuizVO.from(q)).collect(Collectors.toList());
	}
	
	@Override
	public List<Integer> getRandomQuestionIds(List<QuestionVO> allQuestions, int noOfQuestions) {
		
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).map(QuestionVO::id).collect(Collectors.toList());
	}
	

	@Override
	public List<QuestionVO> getQuesByTopicAndNoOfQues(String topic, int noOfQuestions){
		List<QuestionVO> allQuestions = questionClient.getAllQuestionsByTopic(topic);
		Collections.shuffle(allQuestions);
		return allQuestions.stream().limit(noOfQuestions).collect(Collectors.toList());
	} 
	

	@Override
	public QuizVO takeQuiz(long quizId,List<String> answers) {
		Quiz quiz = quizRepo.getReferenceById(quizId);
		quiz.setAnswers(answers);
		quiz = quizRepo.save(quiz);
		return QuizVO.from(quiz);		
	}
	

	@Override
	public List<String> getAnswers (long id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return quiz.getAnswers();
	}
	

	@Override
	public List<QuestionVO> getQuestionsByQuiz(long id){
		Quiz quiz = quizRepo.getReferenceById(id);
		return questionClient.getQuestionsByIds(quiz.getQuestionIds());
	}
	

}

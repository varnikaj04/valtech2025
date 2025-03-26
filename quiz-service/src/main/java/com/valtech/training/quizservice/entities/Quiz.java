package com.valtech.training.quizservice.entities;

import java.util.List;

import com.valtech.training.quizservice.vos.QuestionVO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
	private long quizId;
	private int noOfQues;
	private String topic;

	@ElementCollection
	@CollectionTable(name = "quiz_questions", joinColumns = @JoinColumn(name = "quiz_id"))
	@Column(name = "questionId")
	private List<Integer> questionIds;
	
	@ElementCollection
	@CollectionTable(name = "quiz_answer", joinColumns = @JoinColumn(name="quiz_id"))
	@Column(name = "answers")
	private List<String> answers;

	public Quiz() {}

	public Quiz(int noOfQues, String topic) {
		this.noOfQues = noOfQues;
		this.topic = topic;
	}

	public Quiz(int noOfQues, String topic, List<Integer> questionIds, List<String> answers) {
		this.noOfQues = noOfQues;
		this.topic = topic;
		this.questionIds = questionIds;
		this.answers = answers;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public int getNoOfQues() {
		return noOfQues;
	}

	public void setNoOfQues(int noOfQues) {
		this.noOfQues = noOfQues;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}
	
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}

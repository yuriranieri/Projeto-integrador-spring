package com.pi.mundomatica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Alternative")
public class AlternativeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "true_false")
	private Boolean trueFalse;

	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	@JsonIgnore
	private QuestionEntity question;

	public AlternativeEntity() {
	}

	public AlternativeEntity(Boolean trueFalse, String value, QuestionEntity question) {
		this.trueFalse = trueFalse;
		this.value = value;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTrueFalse() {
		return trueFalse;
	}

	public void setTrueFalse(Boolean trueFalse) {
		this.trueFalse = trueFalse;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
	
}

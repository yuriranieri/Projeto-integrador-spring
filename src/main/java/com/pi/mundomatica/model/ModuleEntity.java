package com.pi.mundomatica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Module")
public class ModuleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String content;
	private String thematic;

	@OneToMany(mappedBy = "module", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<QuestionEntity> questions;

	public ModuleEntity() {
	}

	public ModuleEntity(String name, String content, String thematic) {
		this.name = name;
		this.content = content;
		this.thematic = thematic;
	}
	
	public ModuleEntity(String name, String content, String thematic, List<QuestionEntity> questions) {
		this.name = name;
		this.content = content;
		this.thematic = thematic;
		this.questions = questions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThematic() {
		return thematic;
	}

	public void setThematic(String thematic) {
		this.thematic = thematic;
	}

	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

}

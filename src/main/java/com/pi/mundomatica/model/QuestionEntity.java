package com.pi.mundomatica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String difficulty;

	@OneToMany(mappedBy = "question", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private List<AlternativeEntity> alternatives;

	@ManyToOne
	@JoinColumn(name = "module_id")
	private ModuleEntity module;

	public QuestionEntity() {
	}

	public QuestionEntity(String description, String difficulty, List<AlternativeEntity> alternatives,
			ModuleEntity module) {
		this.description = description;
		this.difficulty = difficulty;
		this.alternatives = alternatives;
		this.module = module;
	}

	public QuestionEntity(ModuleEntity module) {
		this.module = module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public List<AlternativeEntity> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<AlternativeEntity> alternatives) {
		this.alternatives = alternatives;
	}

	public ModuleEntity getModule() {
		return module;
	}

	public void setModule(ModuleEntity module) {
		this.module = module;
	}
	
}

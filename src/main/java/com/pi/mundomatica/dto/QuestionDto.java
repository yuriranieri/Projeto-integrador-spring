package com.pi.mundomatica.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pi.mundomatica.model.AlternativeEntity;
import com.pi.mundomatica.model.ModuleEntity;
import com.pi.mundomatica.model.QuestionEntity;

public class QuestionDto {

	private Long id;
	private String description;
	private String difficulty;
	private ModuleEntity module;
	private List<AlternativeEntity> alternatives;

	public QuestionDto() {
	}

	public QuestionDto(Long id, String description, String difficulty, ModuleEntity module,
			List<AlternativeEntity> alternatives) {
		this.id = id;
		this.description = description;
		this.difficulty = difficulty;
		this.module = module;
		this.alternatives = alternatives;
	}

	public QuestionDto(QuestionEntity entity) {
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.difficulty = entity.getDifficulty();
		this.module = entity.getModule();
		this.alternatives = entity.getAlternatives();
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

	public ModuleEntity getModule() {
		return module;
	}

	public void setModule(ModuleEntity module) {
		this.module = module;
	}

	public List<AlternativeEntity> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<AlternativeEntity> alternatives) {
		this.alternatives = alternatives;
	}

	public static List<QuestionDto> convertToList(List<QuestionEntity> questions) {
		return questions.stream().map(QuestionDto::new).collect(Collectors.toList());
	}

}

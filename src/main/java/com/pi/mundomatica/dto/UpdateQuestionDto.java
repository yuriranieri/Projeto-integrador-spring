package com.pi.mundomatica.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateQuestionDto {

	@NotNull
	private Long id;

	@NotNull
	@NotEmpty
	private String description;

	@NotNull
	@NotEmpty
	private String difficulty;

	@NotNull
	private long moduleId;

	@NotNull
	private List<AlternativeDto> alternatives;

	public UpdateQuestionDto() {
	}

	public UpdateQuestionDto(Long id, String description, String difficulty, long moduleId,
			List<AlternativeDto> alternatives) {
		this.id = id;
		this.description = description;
		this.difficulty = difficulty;
		this.moduleId = moduleId;
		this.alternatives = alternatives;
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

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public List<AlternativeDto> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<AlternativeDto> alternatives) {
		this.alternatives = alternatives;
	}

}

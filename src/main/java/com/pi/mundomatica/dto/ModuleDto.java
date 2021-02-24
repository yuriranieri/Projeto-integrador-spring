package com.pi.mundomatica.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pi.mundomatica.model.ModuleEntity;

public class ModuleDto {

	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String content;

	@NotNull
	@NotEmpty
	private String thematic;

	public ModuleDto() {
	}

	public ModuleDto(Long id, String name, String content, String thematic) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.thematic = thematic;
	}
	
	public ModuleDto(ModuleEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.content = entity.getContent();
		this.thematic = entity.getThematic();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getThematic() {
		return thematic;
	}

	public static List<ModuleDto> convertToList(List<ModuleEntity> modules) {
		return modules.stream().map(ModuleDto::new).collect(Collectors.toList());
	}

	public ModuleEntity covertToEntity(@Valid ModuleDto dto) {
		return new ModuleEntity(dto.getName(), dto.getContent(), dto.getThematic());
	}

}

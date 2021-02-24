package com.pi.mundomatica.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlternativeDto {

	@NotNull
	private Long id;
	
	@NotNull
	private Boolean trueFalse;
	
	@NotNull
	@NotEmpty
	private String value;

	public AlternativeDto() {
	}

	public AlternativeDto(Boolean trueFalse, String value) {
		this.trueFalse = trueFalse;
		this.value = value;
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
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}

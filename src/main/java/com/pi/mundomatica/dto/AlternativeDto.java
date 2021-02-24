package com.pi.mundomatica.dto;

public class AlternativeDto {

	private Long id;
	private Boolean trueFalse;
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

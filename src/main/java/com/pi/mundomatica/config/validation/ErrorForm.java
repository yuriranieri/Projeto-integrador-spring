package com.pi.mundomatica.config.validation;

public class ErrorForm {
	
	private String campo;
	private String error;

	public ErrorForm(String campo, String error) {
		this.campo = campo;
		this.error = error;
	}

	public String getCampo() {
		return campo;
	}

	public String getError() {
		return error;
	}

}

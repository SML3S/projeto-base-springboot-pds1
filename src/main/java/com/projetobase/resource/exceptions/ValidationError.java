package com.projetobase.resource.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError() {
		
	}
	
	public ValidationError(Instant timesTamp, Integer status, String error, String massage, String path) {
		super(timesTamp, status, error, massage, path);
	}
	
	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
}

package com.projetobase.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timesTamp;
	private Integer status;
	private String error;
	private String massage;
	private String path;
	
	public StandardError() {
		
	}

	public StandardError(Instant timesTamp, Integer status, String error, String massage, String path) {
		super();
		this.timesTamp = timesTamp;
		this.status = status;
		this.error = error;
		this.massage = massage;
		this.path = path;
	}

	public Instant getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Instant timesTamp) {
		this.timesTamp = timesTamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}

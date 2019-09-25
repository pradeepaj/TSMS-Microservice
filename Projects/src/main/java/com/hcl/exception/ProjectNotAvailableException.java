package com.hcl.exception;

public class ProjectNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProjectNotAvailableException(String message) {
		super(message);
	}

}
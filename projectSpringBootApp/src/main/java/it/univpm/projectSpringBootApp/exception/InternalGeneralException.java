package it.univpm.projectSpringBootApp.exception;

public class InternalGeneralException extends Exception {


	private static final long serialVersionUID = 3L;

	public InternalGeneralException() {
		super();
	}

	public InternalGeneralException(String message) {
		super(message);
	}
}
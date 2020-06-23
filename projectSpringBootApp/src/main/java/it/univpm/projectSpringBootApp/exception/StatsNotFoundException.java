package it.univpm.projectSpringBootApp.exception;

public class StatsNotFoundException extends ClassNotFoundException{


	private static final long serialVersionUID = 4L;

	public StatsNotFoundException() {
		super();
	}

	public StatsNotFoundException(String message) {
		super(message);
	}
}
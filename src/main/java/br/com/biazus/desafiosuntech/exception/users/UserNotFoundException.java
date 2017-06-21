package br.com.biazus.desafiosuntech.exception.users;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -8554986213139974900L;

	public UserNotFoundException() {
		super("User not found!");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
}

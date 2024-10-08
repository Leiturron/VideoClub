package principal;

public class EmptyValueException extends Exception {
	public EmptyValueException() {
		super("Algunos campos se encuentran vacíos");
	}
}

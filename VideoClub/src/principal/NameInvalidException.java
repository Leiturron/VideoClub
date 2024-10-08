package principal;

public class NameInvalidException extends Exception{
	public NameInvalidException() {
		super("El nombre ingresado es invalido");
	}
}

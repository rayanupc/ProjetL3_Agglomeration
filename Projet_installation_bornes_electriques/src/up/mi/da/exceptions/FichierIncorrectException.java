package up.mi.da.exceptions;
/**
 * Exception vérifiant que le fichier choisi par l'utilisateur respecte bien le format correct pour etre lu
 */
public class FichierIncorrectException extends Exception{

	private static final long serialVersionUID = 8358216770725173464L;
		
	public FichierIncorrectException(String message) {
		super(message);
	}
	
	public FichierIncorrectException() {
		this("");
	}

}

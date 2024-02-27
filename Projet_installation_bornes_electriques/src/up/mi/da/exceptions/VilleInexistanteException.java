package up.mi.da.exceptions;

/**
 * Exception verifiant q'une ville est innexistante dans notre agglomération
 */
public class VilleInexistanteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public VilleInexistanteException(String message) {
		super(message);
	}
	
	public VilleInexistanteException() {
		this("");
	}

}

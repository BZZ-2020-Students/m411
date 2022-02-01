package ipconverter;

/**
 * Diese Klasse liefert ein Fehlertoken, wenn die
 * IP-Adrese ung�ltig ist.
 * @author B163AAL
 *
 */
public class IPFormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IPFormatException(String msg){
		super(msg);
	}

}

package ipconverter;

/**
 * Schnittstelle der Hauptklasse zu den Listener.
 * �ber die Methode update wird einem Listener eine �nderung der Daten signalisiert.
 * 
 * @author  B163AAL
 * @version 1.0
 * @date    22.10.2016
 *
 */
public interface IPAdrConverterListener {

	/**
	 * meldet einem registrierten Listener eine �nderung der Datenwerte.
	 */
	public void update();
}

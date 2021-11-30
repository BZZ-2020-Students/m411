package ipconverter;

/**
 * Diese Schnittstelle legt fest, welche Aufrufe ein Listener an die 
 * Datenklasse zu richten hat.
 * 
 * @author  B163AAL
 * @version 1.0
 * @date    22.10.2016
 *
 */
public interface IPAdrConverterIF {
	/**
	 * Diese Methode wird vom Listener aufgerufen, um eine Stringrepr�sentation einer
	 * IP-Adresse in klassischem IP-V4 Format umzurechnen.
	 * 
	 * Die Methode pr�ft den String auf seine G�ltigkeit. Im Fehlerfall wird eine
	 * Exception geworfen.
	 * 
	 * Kann der Wert umgewandelt werden, ruft diese Methode die Update-Methode
	 * des IPAdrConverterListener auf.
	 * 
	 * @param ipAdr eine IP-Adresse im klassischen IP-V4 Format
	 * @throws IPFormatException signalisiert ein ung�ltiges IP-Format
	 */
	public void computeIP(String ipAdr) throws IPFormatException;
	
	/**
	 * Diese Methode liefert die bin�re Darstellung einer IP-Adresse.
	 * @return IP-Adresse im Bin�rformat
	 */
	public String getIPAdrBinFormat();
	
	/**
	 * Dise Methode liefert die hex Darstellung einer IP-Adresse.
	 * @return IP-Adresse im HEX-Format
	 */
	public String getIPAdrHexFormat();

	/** 
	 * F�gt einen Listener zu.
	 * Der Listener wird in einer Liste eingetragen und bei einer Wert�nderung
	 * �ber die Methode update() informiert.
	 * @param l ein Listener-Objekt
	 */
	public void addIPAdrConverterListener(IPAdrConverterListener l);
	
	/** 
	 * Entfernt einen Listener.
	 * @param l ein Listener-Objekt
	 */
	public void removeIPAdrConverterListener(IPAdrConverterListener l);
}

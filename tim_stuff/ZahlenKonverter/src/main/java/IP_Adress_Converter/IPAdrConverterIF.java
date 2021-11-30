package IP_Adress_Converter;

/**
 * Diese Schnittstelle legt fest, welche Aufrufe ein Listener an die
 * Datenklasse zu richten hat.
 *
 * @author B163AAL
 * @version 1.0
 * @date 22.10.2016
 */
public interface IPAdrConverterIF {
    /**
     * Diese Methode wird vom Listener aufgerufen, um eine Stringrepräsentation einer
     * IP-Adresse in klassischem IP-V4 Format umzurechnen.
     * <p>
     * Die Methode prüft den String auf seine Gültigkeit. Im Fehlerfall wird eine
     * Exception geworfen.
     * <p>
     * Kann der Wert umgewandelt werden, ruft diese Methode die Update-Methode
     * des IPAdrConverterListener auf.
     *
     * @param ipAdr eine IP-Adresse im klassischen IP-V4 Format
     * @throws IPFormatException signalisiert ein ungültiges IP-Format
     */
    public void computeIP(String ipAdr) throws IPFormatException;

    /**
     * Diese Methode liefert die binäre Darstellung einer IP-Adresse.
     *
     * @return IP-Adresse im Binärformat
     */
    public String getIPAdrBinFormat();

    /**
     * Dise Methode liefert die hex Darstellung einer IP-Adresse.
     *
     * @return IP-Adresse im HEX-Format
     */
    public String getIPAdrHexFormat();

    /**
     * Fügt einen Listener zu.
     * Der Listener wird in einer Liste eingetragen und bei einer Wertänderung
     * über die Methode update() informiert.
     *
     * @param l ein Listener-Objekt
     */
    public void addIPAdrConverterListener(IPAdrConverterListener l);

    /**
     * Entfernt einen Listener.
     *
     * @param l ein Listener-Objekt
     */
    public void removeIPAdrConverterListener(IPAdrConverterListener l);
}

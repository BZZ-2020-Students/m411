package IP_Adress_Converter;

import java.util.Vector;

/**
 * Hauptklasse der Anwendung IP-Adress Converter.
 * Sie instanziert alle benötigten Klassen in der main-Methode.
 * <p>
 * Über die Methode computeIP() wird eine IP-Adresse im Format
 * 192.168.1.1 geliefert. Diese wird danach in ein binäres und ein
 * hexadezimales Format übersetzt.
 * Nach der Berechnung werden alle angemeldeten Listener (müssen das
 * Interface IPAdrConverterListener implementieren) über die
 * Methode update() informiert, dass eine Änderung der Datenwerte
 * stattgefunden hat.
 * <p>
 * Mit den Methoden getIPAdrBinFormat() und getIPAdrHexFormat() können
 * die Listener die Datenwerte abfragen.
 *
 * @author B163AAL
 * @version 1.0
 * @date 22.10.2016
 */
public class IPAdrConverter implements IPAdrConverterIF {

    private Vector<IPAdrConverterListener> listener;
    private String binFormat, hexFormat;

    /**
     * Erstellt die Hauptklasse für die Umrechunung einer IP-Adresse in ein
     * binäres bzw. hexadezimales Format.
     * <p>
     * Für die Registrierung der Listener wird ein Vector vorbereitet.
     */
    public IPAdrConverter() {
        listener = new Vector<IPAdrConverterListener>();
    }

    /**
     * Erzeugt die Applikation mit den Klassen für Datenmodel und GUI.
     *
     * @param args
     */
    public static void main(String[] args) {
        IPAdrConverter conv = new IPAdrConverter();
        IPAdrConverterGUI gui = new IPAdrConverterGUI(conv);
    }

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
    public void computeIP(String ipAdr) throws IPFormatException {
        //
        // ... hier muss die Routine kommen, um die Werte umzuwandeln.
        // 1. Das Format prüfen und bei ungültigem Wert eine Exception werfen.
        //    Exception mittels throw new IPFormatException("Fehlermeldung") auslösen.
        //
        //    HINWEIS: Profis werden die IP-Adresse mittels einer REGEX (regular expression)
        //             auf deren Richtigkeit prüfen und auch gleich die Zerlegung in
        //             4 Zahlenwerte vornehmen.
        //             Diese Technik dürfte die aktuelle Fähigkeit der meisten Lernenden
        //             übertreffen. Wer Lust hat.... try it.
        //    Einfacher ist es, wenn mit den Möglichkeiten der String-Klasse gearbeitet wird.
        //

        // 2. Den Wert umwandeln in 8-stelligen Binär- und 2-stelliegn Hexwert.

        // 3. Alle angemeldeten Listener über die Wertänderung informieren.
        this.fireChanges();
    }

    /**
     * Diese Methode liefert die binäre Darstellung einer IP-Adresse
     *
     * @return IP-Adresse im Binärformat
     */
    public String getIPAdrBinFormat() {
        return binFormat;
    }

    /**
     * Dise Methode liefert die hex Darstellung einer IP-Adresse
     *
     * @return IP-Adresse im HEX-Format
     */
    public String getIPAdrHexFormat() {
        return hexFormat;
    }

    /**
     * Fügt einen Listener zu.
     * Der Listener wird in einer Liste eingetragen und bei einer Wertänderung
     * über die Methode update() informiert.
     *
     * @param l ein Listener-Objekt
     */
    public void addIPAdrConverterListener(IPAdrConverterListener l) {
        listener.add(l);
    }

    /**
     * Entfernt einen Listener.
     *
     * @param l ein Listener-Objekt
     */
    public void removeIPAdrConverterListener(IPAdrConverterListener l) {
        listener.remove(l);
    }

    /*
     * Bei einer Änderung der Daten werden alle aktuellen
     * Listener über diese Änderung informiert.
     */
    private void fireChanges() {
        for (IPAdrConverterListener l : listener) {
            l.update();
        }
    }
}

package IP_Adress_Converter;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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
    private String binFormat = "", hexFormat = "";

    /**
     * Erstellt die Hauptklasse für die Umrechunung einer IP-Adresse in ein
     * binäres bzw. hexadezimales Format.
     * <p>
     * Für die Registrierung der Listener wird ein Vector vorbereitet.
     */
    public IPAdrConverter() {
        listener = new Vector<>();
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
        List<Integer> ints;
        String regex = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        if (ipAdr.matches(regex)) {
            ints = Arrays.stream(ipAdr.split("\\."))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println("splitted = " + ints);
        } else {
            throw new IPFormatException("Wrong format");
        }

        for (int i = 0; i < 4; i++) {
            int num = ints.get(i);
            hexFormat += Integer.toString(num, 16);
            binFormat += Integer.toString(num, 2);

            if (i < 3) {
                hexFormat += "-";
                binFormat += "-";
            }
        }

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

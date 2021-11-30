package ipzahlenkonverter; /**
 * Hauptklasse der Anwendung IP-Adress Converter.
 * Sie instanziert alle benötigten Klassen in der main-Methode.
 * 
 * Über die Methode computeIP() wird eine IP-Adresse im Format
 * 192.168.1.1 geliefert. Diese wird danach in ein binäres und ein
 * hexadezimales Format übersetzt.
 * Nach der Berechnung werden alle angemeldeten Listener (müssen das
 * Interface IPAdrConverterListener implementieren) über die
 * Methode update() informiert, dass eine Änderung der Datenwerte 
 * stattgefunden hat.
 * 
 * Mit den Methoden getIPAdrBinFormat() und getIPAdrHexFormat() können
 * die Listener die Datenwerte abfragen.
 * 
 * @author  B163AAL
 * @version 1.0
 * @date    22.10.2016
 */
import java.util.*;

public class IPAdrConverter implements IPAdrConverterIF {
  
  private Vector<IPAdrConverterListener> listener;
  private String binFormat, hexFormat;

  /**
   * Erstellt die Hauptklasse für die Umrechunung einer IP-Adresse in ein
   * binäres bzw. hexadezimales Format.
   * 
   * Für die Registrierung der Listener wird ein Vector vorbereitet.
   * 
   */
  public IPAdrConverter(){
    listener = new Vector<IPAdrConverterListener>();
  }
  
  /**
   * Diese Methode wird vom Listener aufgerufen, um eine Stringrepräsentation einer
   * IP-Adresse in klassischem IP-V4 Format umzurechnen.
   * 
   * Die Methode prüft den String auf seine Gültigkeit. Im Fehlerfall wird eine
   * Exception geworfen.
   * 
   * Kann der Wert umgewandelt werden, ruft diese Methode die Update-Methode
   * des IPAdrConverterListener auf.
   * 
   * @param ipAdr eine IP-Adresse im klassischen IP-V4 Format
   * @throws IPFormatException signalisiert ein ungültiges IP-Format
   */
  public void computeIP(String ipAdr) throws IPFormatException{
    String[] array = ipAdr.split("\\.");
    String[] hexarray = new String[array.length];
    String[] binarray = new String[array.length];
    for (int i = 0; i < array.length; i++) {
      hexarray[i] = String.format("%2s", Integer.toHexString(Integer.parseInt(array[i]))).replace(' ', '0');
      binarray[i] = String.format("%8s", Integer.toBinaryString(Integer.parseInt(array[i]))).replace(' ', '0');
    }

    binFormat = String.join("-", binarray);
    hexFormat = String.join("-",hexarray);

    // 3. Alle angemeldeten Listener über die Wertänderung informieren.
    this.fireChanges();
  }
  
  /**
   * Diese Methode liefert die binäre Darstellung einer IP-Adresse
   * @return IP-Adresse im Binärformat
   */
  public String getIPAdrBinFormat(){
    return binFormat;
  }
  
  /**
   * Dise Methode liefert die hex Darstellung einer IP-Adresse
   * @return IP-Adresse im HEX-Format
   */
  public String getIPAdrHexFormat(){
    return hexFormat;
  }
  
  
  /** 
   * Fügt einen Listener zu.
   * Der Listener wird in einer Liste eingetragen und bei einer Wertänderung
   * über die Methode update() informiert.
   * @param l ein Listener-Objekt
   */
  public void addIPAdrConverterListener(IPAdrConverterListener l){
    listener.add(l);
  }
  
  /** 
   * Entfernt einen Listener.
   * @param l ein Listener-Objekt
   */
  public void removeIPAdrConverterListener(IPAdrConverterListener l){
    listener.remove(l);
  }
  
  /*
   * Bei einer Änderung der Daten werden alle aktuellen 
   * Listener über diese Änderung informiert.
   */
  private void fireChanges(){
    for (IPAdrConverterListener l : listener){
      l.update();
    }
  }
  

  /**
   * Erzeugt die Applikation mit den Klassen für Datenmodel und GUI.
   * @param args
   */
  public static void main(String[] args){
    IPAdrConverter conv   = new IPAdrConverter();
    IPAdrConverterGUI gui = new IPAdrConverterGUI(conv);
  }
/*
                    ___..................____
           _..--''~_______   _____...----~~~\\
       __.'    .-'~       \\~      [_`.7     \\
 .---~~      .'            \\           __..--\\_
/             `-._          \\   _...~~~_..---~  ~~~~~~~~~~~~--.._
\              /  ~~~~~~----_\`-~_-~~__          ~~~~~~~---.._    ~--.__
 \     _       |==            |   ~--___--------...__          `-   _.--"""|
  \ __/.-._\   |              |            ~~~~--.  `-._ ___...--~~~_.'|_Y |
   `--'|/~_\\  |              |     _____           _.~~~__..--~~_.-~~~.-~/
     | ||| |\\_|__            |.../.----.._.        | Y |__...--~~_.-~  _/
      ~\\\ || ~|..__---____   |||||  .'~-. \\       |_..-----~~~~   _.~~
        \`-'/ /     ~~~----...|'''|  |/"_"\ \\   |~~'           __.~
         `~~~'                 ~~-:  ||| ~| |\\  |        __..~~
                                   ~~|||  | | \\/  _.---~~
                                     \\\  //  | ~~~
                                      \`-'/  / dp
                                       `~~~~'
 */
}

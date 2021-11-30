package ipConverter; /**
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
    System.out.println(ipAdr);
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

    String[] strNumbers = ipAdr.split("\\.");
    int[] numbers = new int[4];
    int count = 0;
    for (String str : strNumbers){
      numbers[count++] = Integer.parseInt(str);
    }
    // 2. Den Wert umwandeln in 8-stelligen Binär- und 2-stelliegn Hexwert.

    binFormat = "";
    count = 0;
    for (int n : numbers){
      String tempBinary = getBinary(n);
      for(int i = tempBinary.length(); i < 8; i++){
        tempBinary = "0" + tempBinary;
      }
      binFormat += tempBinary;
      if(count < 3){
        binFormat+= "-";
        count++;
      }
    }
    System.out.println(binFormat);

    hexFormat = "";
    count = 0;
    for (int n : numbers){
      String tempHex = getHex(n);
      for(int i = tempHex.length(); i < 2; i++){
        tempHex = "0" + tempHex;
      }
      hexFormat += tempHex;
      if(count < 3){
        hexFormat+= "-";
        count++;
      }
    }
    System.out.println(hexFormat);

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

  public String getBinary(int number){
    ArrayList<Integer> binary = new ArrayList<>();
    String strBinary = "";
    while(number > 0){
      binary.add(number%2);
      number = number/2;
    }
    for(int b : binary){
      strBinary = b + strBinary;
    }
    return strBinary;
  }

  public String getHex(int number) {
    String strHexadecimal = "";
    while(number != 0)
    {
      int hexNumber = number % 16;
      char charHex;
      if(hexNumber <= 9 && hexNumber >= 0)
      {
        charHex = (char)(hexNumber + '0');
      }
      else
      {
        charHex = (char)(hexNumber - 10 + 'A');
      }
      strHexadecimal = charHex + strHexadecimal;
      number = number / 16;
    }
    return strHexadecimal;
  }
}

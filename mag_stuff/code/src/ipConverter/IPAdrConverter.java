package ipConverter; /**
 * Hauptklasse der Anwendung IP-Adress Converter.
 * Sie instanziert alle ben�tigten Klassen in der main-Methode.
 * 
 * �ber die Methode computeIP() wird eine IP-Adresse im Format
 * 192.168.1.1 geliefert. Diese wird danach in ein bin�res und ein
 * hexadezimales Format �bersetzt.
 * Nach der Berechnung werden alle angemeldeten Listener (m�ssen das
 * Interface IPAdrConverterListener implementieren) �ber die
 * Methode update() informiert, dass eine �nderung der Datenwerte 
 * stattgefunden hat.
 * 
 * Mit den Methoden getIPAdrBinFormat() und getIPAdrHexFormat() k�nnen
 * die Listener die Datenwerte abfragen.
 * 
 * @author  B163AAL
 * @version 1.0
 * @date    22.10.2016
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdrConverter implements IPAdrConverterIF {
  
  private Vector<IPAdrConverterListener> listener;
  private String binFormat, hexFormat;

  /**
   * Erstellt die Hauptklasse f�r die Umrechunung einer IP-Adresse in ein
   * bin�res bzw. hexadezimales Format.
   * 
   * F�r die Registrierung der Listener wird ein Vector vorbereitet.
   * 
   */
  public IPAdrConverter(){
    listener = new Vector<IPAdrConverterListener>();
  }
  
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
  public void computeIP(String ipAdr) throws IPFormatException{
    //
    // ... hier muss die Routine kommen, um die Werte umzuwandeln.
    // 1. Das Format pr�fen und bei ung�ltigem Wert eine Exception werfen.
    //    Exception mittels throw new IPFormatException("Fehlermeldung") ausl�sen.
    //    
    //    HINWEIS: Profis werden die IP-Adresse mittels einer REGEX (regular expression)
    //             auf deren Richtigkeit pr�fen und auch gleich die Zerlegung in
    //             4 Zahlenwerte vornehmen.
    //             Diese Technik d�rfte die aktuelle F�higkeit der meisten Lernenden
    //             �bertreffen. Wer Lust hat.... try it.
    //    Einfacher ist es, wenn mit den M�glichkeiten der String-Klasse gearbeitet wird.
    //

    if (ipAdr.matches(ipRegex)) {
      String[] strNumbers = ipAdr.split("\\.");
      int[] numbers = new int[4];
      int count = 0;
      for (String str : strNumbers) {
        numbers[count++] = Integer.parseInt(str);
      }
      // 2. Den Wert umwandeln in 8-stelligen Bin�r- und 2-stelliegn Hexwert.

      binFormat = "";
      count = 0;
      for (int n : numbers) {
        String tempBinary = getBinary(n);
        for (int i = tempBinary.length(); i < 8; i++) {
          tempBinary = "0" + tempBinary;
        }
        binFormat += tempBinary;
        if (count < 3) {
          binFormat += "-";
          count++;
        }
      }

      hexFormat = "";
      count = 0;
      for (int n : numbers) {
        String tempHex = getHex(n);
        for (int i = tempHex.length(); i < 2; i++) {
          tempHex = "0" + tempHex;
        }
        hexFormat += tempHex;
        if (count < 3) {
          hexFormat += "-";
          count++;
        }
      }

      // 3. Alle angemeldeten Listener �ber die Wert�nderung informieren.
      this.fireChanges();
    }
  }
  
  /**
   * Diese Methode liefert die bin�re Darstellung einer IP-Adresse
   * @return IP-Adresse im Bin�rformat
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
   * F�gt einen Listener zu.
   * Der Listener wird in einer Liste eingetragen und bei einer Wert�nderung
   * �ber die Methode update() informiert.
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
   * Bei einer �nderung der Daten werden alle aktuellen 
   * Listener �ber diese �nderung informiert.
   */
  private void fireChanges(){
    for (IPAdrConverterListener l : listener){
      l.update();
    }
  }
  

  /**
   * Erzeugt die Applikation mit den Klassen f�r Datenmodel und GUI.
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

    private static final String ipRegex =
          "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

}

package v2_0;

public class ZahlenkonverterApp {
    public static void main(String[] args) {
        String eingegebeneZahl;
        Zahlenkonverter konverter = new Zahlenkonverter();
        eingegebeneZahl = konverter.Usereingaben();

        konverter.convert(eingegebeneZahl);
        konverter.printAllNumbers();
    }
}

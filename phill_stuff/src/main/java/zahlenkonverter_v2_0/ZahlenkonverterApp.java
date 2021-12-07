package zahlenkonverter_v2_0;

public class ZahlenkonverterApp {
    public static void main(String[] args) {
        Zahlenkonverter konverter = new Zahlenkonverter();
//        eingegebeneZahl = konverter.Usereingaben();

//        konverter.convert(eingegebeneZahl);
        konverter.Usereingaben();

        konverter.printAllNumbers();
    }
}

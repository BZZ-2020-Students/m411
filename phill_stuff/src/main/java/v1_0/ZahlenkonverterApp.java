package v1_0;

public class ZahlenkonverterApp {
    public static void main(String[] args) {
        Zahlenkonverter konverter = new Zahlenkonverter();
        konverter.Usereingaben();
        konverter.convert();
        konverter.printAllNumbers();
    }
}

package ZahlenKonverterBasic;

import java.util.Scanner;

public class ZahlenKonverter {
    public ZahlenKonverter() {
        boolean validNumber = false;
        Scanner scanner = new Scanner(System.in);
        while(!validNumber) {
            System.out.print("Bitte eine Zahl eingeben: ");
            String numberString = scanner.nextLine();

            try {
                float number = Float.parseFloat(numberString);
                validNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Dies ist keine gültige Zahl!");
            }
        }
    }

    public static void main(String[] args) {
        new ZahlenKonverter();
    }
}

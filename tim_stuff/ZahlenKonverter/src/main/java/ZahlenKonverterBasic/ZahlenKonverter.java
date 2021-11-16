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
                int number = Integer.parseInt(numberString);
                validNumber = true;

                System.out.println("Ihre Zahl: " + number);
                System.out.println("In Hex: " + Integer.toString(number, 16));
                System.out.println("In Bin: " + Integer.toString(number, 2));
            } catch (NumberFormatException e) {
                System.out.println("Dies ist keine gültige Zahl!");
            }
        }
    }

    public static void main(String[] args) {
        new ZahlenKonverter();
    }
}

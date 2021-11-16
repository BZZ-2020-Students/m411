package ZahlenKonverterHandarbeit;

import java.util.ArrayList;
import java.util.Scanner;

public class ZahlenKonverter {
    public ZahlenKonverter() {
        int number = validInt("Bitte eine Zahl eingeben: ");
        int numberSystem = validInt("Bitte ein Zahlensystem angeben (2-36): ");
        System.out.println("Ihre Zahl: " + number);
        System.out.println("Ihre Zahl mit Basis von " + numberSystem + ": " + convert(number, numberSystem));
    }

    public int validInt(String message) {
        boolean validNumber = false;
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (!validNumber) {
            System.out.print(message);
            String numberString = scanner.nextLine();

            try {
                number = Integer.parseInt(numberString);
                validNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Dies ist keine gültige Zahl!");
            }
        }
        return number;
    }

    public String convert(int number, int numberSystem) {
        // Source: https://www.tutorialspoint.com/computer_logical_organization/number_system_conversion.htm
        if (numberSystem < 2) {
            numberSystem = 2;
        } else if (numberSystem > 36) {
            numberSystem = 36;
        }
        int result = number / numberSystem;
        int remainder = number % numberSystem;
        StringBuilder newNumber = new StringBuilder();
        ArrayList<Integer> newNumbers = new ArrayList<>();
        newNumbers.add(remainder);
        while (result != 0) {
            remainder = result % numberSystem;
            result /= numberSystem;
            newNumbers.add(remainder);
        }

        for (int i = newNumbers.size() - 1; i >= 0; i--) {
            int num = newNumbers.get(i);
            String numString = "" + num;
            if (num > 9) {
                numString = "" + (char) (65 + (num - 10));
            }

            newNumber.append(numString);
        }

        return newNumber.toString();
    }

    public static void main(String[] args) {
        new ZahlenKonverter();
    }
}

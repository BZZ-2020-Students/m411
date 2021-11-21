package ZahlenKonverterExperte;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ZahlenKonverter {
    Scanner scanner = new Scanner(System.in);
    private final int MIN_BASE = 2;
    private final int MAX_BASE = 36;

    public ZahlenKonverter() {
        int whatToDo = validInt("""
                (1) Dezimal zu andere
                (2) anderes zu Dezimal
                (3) anderes zu anderes
                >\s""");

        int number = 0;
        int numberSystem = 0;
        String otherNumber = "";
        switch (whatToDo) {
            case 1 -> {
                number = validInt("Bitte ihre Zahl eingeben: ");
                numberSystem = validInt("Bitte ein Zahlensystem angeben (" + MIN_BASE + "-" + MAX_BASE + "): ");
                System.out.println("Ihre Zahl: " + number);
                System.out.println("Ihre Zahl mit Basis von " + numberSystem + ": " + convertToOtherBaseSystem(number, numberSystem));
            }
            case 2 -> {
                System.out.print("Bitte ihre Zahl eingeben: ");
                otherNumber = scanner.nextLine();
                numberSystem = validInt("Bitte das Zahlensystem der Zahl angeben (" + MIN_BASE + "-" + MAX_BASE + "): ");
                System.out.println("Ihre Zahl: " + otherNumber + " mit Basis von " + numberSystem);
                System.out.println("Ihre Zahl in Dezimal: " + convertToDecimal(otherNumber, numberSystem));
            }
            case 3 -> {
                System.out.print("Bitte ihre Zahl eingeben: ");
                otherNumber = scanner.nextLine();
                numberSystem = validInt("Bitte das Zahlensystem der Zahl angeben (" + MIN_BASE + "-" + MAX_BASE + "): ");
                int secondNumberSystem = validInt("Bitte das Zahlensystem angeben in der Sie ihre Zahl umwandeln wollen angeben (" + MIN_BASE + "-" + MAX_BASE + "): ");
                System.out.println("Ihre Zahl: '" + otherNumber + "' mit Basis von '" + numberSystem + "'");
                System.out.println("Ihre Zahl mit Basis von '" + secondNumberSystem + "': " + convertOtherToOther(otherNumber, numberSystem, secondNumberSystem));
            }
        }
    }

    public int validInt(String message) {
        boolean validNumber = false;
        int number = -1;
        while (!validNumber) {
            System.out.print(message);
            String numberString = scanner.nextLine();

            try {
                number = Integer.parseInt(numberString);
                validNumber = true;
            } catch (NumberFormatException e) {
                System.err.println("Dies ist keine gültige Zahl!");
            }
        }
        return number;
    }

    public String convertOtherToOther(String num, int base1, int base2) {
        int decimal = convertToDecimal(num, base1);
        return convertToOtherBaseSystem(decimal, base2);
    }

    public int convertToDecimal(String otherBaseNumber, int base) {
        // Source: https://www.tutorialspoint.com/computer_logical_organization/number_system_conversion.htm

        otherBaseNumber = otherBaseNumber.toUpperCase(Locale.ROOT);
        char[] chars = otherBaseNumber.toCharArray();
        int baseCounter = otherBaseNumber.length() - 1;
        int result = 0;
        for (char c : chars) {
            int num = 0;
            int charToIntOffset = 49;
            int charToIntOffsetAdder = 1;
            if (c > 57) {
                charToIntOffset = 65;
                charToIntOffsetAdder = 10;
            }

            num = (int) c - charToIntOffset + charToIntOffsetAdder;
            result += (num * Math.pow(base, baseCounter--));
        }

        return result;
    }

    public String convertToOtherBaseSystem(int number, int numberSystem) {
        // Source: https://www.tutorialspoint.com/computer_logical_organization/number_system_conversion.htm
        if (numberSystem == 10) {
            return "" + number;
        } else if (numberSystem < MIN_BASE) {
            numberSystem = MIN_BASE;
        } else if (numberSystem > MAX_BASE) {
            numberSystem = MAX_BASE;
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

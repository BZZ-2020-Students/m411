package v2_0;

import java.util.Scanner;

public class Einleser {
    static Scanner scanner;


    public Einleser() {
        scanner = new Scanner(System.in);
    }

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next();
        }
        double zahl = scanner.nextDouble();
        return zahl;
    }

    public float readFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next();
        }
        float zahl = scanner.nextFloat();
        return zahl;
    }

    public int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Bitte eine Ganzzahl eingeben!");
            scanner.next();
        }
        int zahl = scanner.nextInt();
        return zahl;
    }

    public boolean readBoolean() {
        while (!scanner.hasNextBoolean()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next();
        }
        boolean zahl = scanner.nextBoolean();
        return zahl;
    }

    public String readString() {
        while (!scanner.hasNextLine()) {
            System.out.println("Bitte eine Zahl eingeben!");
            scanner.next();
        }
        String zahl = scanner.nextLine();
        return zahl;
    }
}


package v1_0;

import java.util.Scanner;

public class Zahlenkonverter {
    private Einleser einleser;
    private int natuerlichezahl = 0;
    private String umgewandelteNummerHex = "";
    private String umgewandelteNummerBIN = "";

    public Zahlenkonverter(){
        einleser = new Einleser();
    }

    public void Usereingaben(){
        System.out.println("Wilkommen beim Zahlenkonverter");
        System.out.println("Geben Sie eine natuerliche Zahl ein");
        natuerlichezahl = einleser.readInt();
    }

    public void convert(){
        umgewandelteNummerHex = Integer.toHexString(natuerlichezahl);
        umgewandelteNummerBIN = Integer.toBinaryString(natuerlichezahl);
    }

    public void printAllNumbers(){
        System.out.println("Natürliche Zahl: " + natuerlichezahl);
        System.out.println("Hex: " + umgewandelteNummerHex);
        System.out.println("BIN: " + umgewandelteNummerBIN);
    }




}

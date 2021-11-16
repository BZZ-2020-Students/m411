package numberconverter;

import java.util.Scanner;

public class Zahlenkonverter {
    private Scanner scanner = new Scanner(System.in);
    private final String ALL_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Zahlenkonverter zk = new Zahlenkonverter();
        zk.interaction();
    }

    public void interaction(){
        String input = "";
        String numberToConvert;
        int systemrootFrom;
        int systemrootTo;
        System.out.print("Geben Sie eine Zahl ein > ");
        numberToConvert = scanner.nextLine();

        do {
            System.out.print("In welchem System wurde diese Zahl eingegeben > ");
            input = scanner.nextLine();
        }while(!validInput(input));
        systemrootFrom =  Integer.parseInt(input);
        do {
            System.out.print("In welchem System soll diese Zahl umgewandelt werden > ");
            input = scanner.nextLine();
        }while(!validInput(input));
        systemrootTo =  Integer.parseInt(input);
        System.out.println(numberToConvert + " ist im " + systemrootFrom + "er System "  + convertDezToAny(toDec(numberToConvert,systemrootFrom),systemrootTo));
    }

    public int toDec(String number, int systemroot) {
        number = number.toUpperCase();
        int resDez = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int d = ALL_DIGITS.indexOf(c);
            resDez = systemroot * resDez + d;
        }
        return resDez;
    }


    public String convertDezToAny(int dez, int systemRoot){
        int tempInput = dez;
        StringBuilder hexString = new StringBuilder();
        while(tempInput > systemRoot){
            int tempInt = tempInput % systemRoot;
            hexString.append(checkLargerThenTen(tempInt));
            tempInput /= systemRoot;
        }
        hexString.append(checkLargerThenTen(tempInput));
        return String.valueOf(new StringBuilder(hexString).reverse());
    }
    public String convertDezToHex(int dez){
        int tempInput = dez;
        StringBuilder hexString = new StringBuilder();
        while(tempInput > 16){
            int tempInt = tempInput % 16;
            hexString.append(checkLargerThenTen(tempInt));
            tempInput /= 16;
        }
        hexString.append(checkLargerThenTen(tempInput));
        return String.valueOf(new StringBuilder(hexString).reverse());
    }

    public String checkLargerThenTen(int input){
        if(input >= 10){
            input -= 9;
            return String.valueOf(Character.toChars(64 + input));
        }else{
            return String.valueOf(input);
        }
    }

    public String convertDezToBinary(int dez){
        int tempInput = dez;
        StringBuilder binaryString = new StringBuilder();
        while(tempInput > 1){
            binaryString.append(tempInput % 2);
            tempInput /= 2;
        }
        binaryString.append(tempInput);
        return String.valueOf(new StringBuilder(binaryString).reverse());
    }

    public boolean validInput(String unparsedInput){
        try {
            int input = Integer.parseInt(unparsedInput);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}

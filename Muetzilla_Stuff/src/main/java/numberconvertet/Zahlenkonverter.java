package numberconvertet;

import java.util.Scanner;

public class Zahlenkonverter {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Zahlenkonverter zk = new Zahlenkonverter();
        zk.interaction();
    }

    public void interaction(){
        String input = "";
        int numberToConvert = 0;
        do {
            System.out.print("Welche Zahl soll in ein anders System umgewandelt werden > ");
            input = scanner.nextLine();
        }while(!validInput(input));
        numberToConvert =  Integer.parseInt(input);
        System.out.println("In Bin with libary: " + Integer.toBinaryString(numberToConvert));
        System.out.println("In Hex with libary: " + Integer.toHexString(numberToConvert));
        System.out.println("In Bin Aufgabe 2: " + convertDezToBinary(numberToConvert));
        System.out.println("In Hex Aufgabe 2: " + convertDezToHex(numberToConvert));

    }
    public String convertDezToHex(int dez){
        int tempInput = dez;
        StringBuilder hexString = new StringBuilder();
        while(tempInput > 16){
            System.out.println(tempInput);
            int tempInt = tempInput % 16;
            hexString.append(checkLargerThenTen(tempInt));
            tempInput /= 16;
        }
        hexString.append(checkLargerThenTen(tempInput));
        String finalHexString = String.valueOf(new StringBuilder(hexString).reverse());
        return finalHexString;
    }

    public String checkLargerThenTen(int input){
        if(input >= 10){
            input -= 9;
            return String.valueOf(Character.toChars(96 + input));
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
        String finalBinaryString = String.valueOf(new StringBuilder(binaryString).reverse());
        return finalBinaryString;
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

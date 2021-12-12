package zahlenkonverter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Zahlenkonverter {
    Scanner scanner = new Scanner(System.in);
    int number;
    public static void main(String[] args) {
//        new Zahlenkonverter().run();
        new Zahlenkonverter().expert();
    }

    public void expert(){
        String num;
        do{
            System.out.print("Gib eine Zahl ein: ");
            num = scanner.nextLine();
        } while (isNumber(num));

        String hex = getHex(number);
        String binary = getBinary(number);

        System.out.println("Binary: " + binary + " Hex: " + hex);
    }




    public void run(){
        String num;
        do{
            System.out.print("Gib eine Zahl ein: ");
            num = scanner.nextLine();
        } while (isNumber(num));

        String binary = Integer.toBinaryString(number);
        String hex = Integer.toHexString(number);

        System.out.println("Binary: " + binary + " Hex: " + hex);


    }

    public String getBinary(int number){
        ArrayList<Integer> binary = new ArrayList<>();
        String strBinary = "";
        while(number > 0){
            binary.add(number%2);
            number = number/2;
        }
        for(int b : binary){
            strBinary = b + strBinary;
        }
        return strBinary;
    }

    public String getHex(int number) {
        String strHexadecimal = "";
        while(number != 0)
        {
            int hexNumber = number % 16;
            char charHex;
            if(hexNumber <= 9 && hexNumber >= 0)
            {
                charHex = (char)(hexNumber + '0');
            }
            else
            {
                charHex = (char)(hexNumber - 10 + 'A');
            }
            strHexadecimal = charHex + strHexadecimal;
            number = number / 16;
        }
        return strHexadecimal;
    }

    public boolean isNumber(String num){
        try {
            number = Integer.parseInt(num);
            return false;
        }catch (Exception e){
            return true;
        }
    }
}

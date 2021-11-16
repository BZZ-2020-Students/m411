package zahlenkonverter;

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

    public boolean isNumber(String num){
        try {
            number = Integer.parseInt(num);
            return false;
        }catch (Exception e){
            return true;
        }
    }
}

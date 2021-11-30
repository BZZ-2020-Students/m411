package basicConverter;

import java.util.Scanner;

public class basicConverter {

    public static void main(String[] args) {
        new basicConverter().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String binaryString = "";
        String hexString = "";
        int number = 0;
        boolean isValid = false;

        while(!isValid){
            System.out.print("Enter a valid number: ");
            String userInput = sc.nextLine();
            try {
              number = Integer.parseInt(userInput);
              isValid=true;
            }catch(NumberFormatException ignored){
            }
        }

        binaryString = Integer.toString(number, 2);
        hexString = Integer.toString(number, 16);

        System.out.println("Binary: " + binaryString);
        System.out.println("Hex: " + hexString);


    }
}

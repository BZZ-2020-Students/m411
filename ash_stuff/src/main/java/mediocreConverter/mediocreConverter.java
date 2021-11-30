package mediocreConverter;

import java.util.ArrayList;
import java.util.Scanner;

public class mediocreConverter {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new mediocreConverter().run();
    }

    public void run() {
        int number = validInt("Enter a valid number: ");
        int base = validInt("Enter a valid base (2-36): ");
        converter(number, base);

    }

    public void converter(int decimal, int base) {
        ArrayList<String> binary = new ArrayList<>();
        while (decimal > 0) {
            int modulo = decimal % base;
            if(modulo > 9){
                modulo += 55;
                char c = (char) modulo;
                binary.add(""+c);
            }else binary.add(""+modulo);
            decimal = decimal / base;
        }

        for (int i = binary.size() - 1; i >= 0; i--) {
            System.out.print(binary.get(i));
        }
    }

    public int validInt(String message) {
        boolean validNumber = false;
        int number = -1;
        while (!validNumber) {
            System.out.print(message);
            String numberString = sc.nextLine();

            try {
                number = Integer.parseInt(numberString);
                validNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!");
            }
        }
        return number;
    }
}

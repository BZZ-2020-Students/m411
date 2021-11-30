package pruefig;

import java.util.Scanner;

public class BubbleSortDescending {
    public static void main(String[] args)
    {
        int number, a, b, temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of integers: ");
        number = 4;
        int[] arrInput = new int[4];
        System.out.println("Enter " + 4 + " integers: ");
        for(a = 0; a < 4; a++)
            arrInput[a] = sc.nextInt();
        for(a = 0; a < (4 - 1); a++)
        {
            for(b = 0; b < 4 - a - 1; b++)
            {
                // logic to sort in descending order
                if(arrInput[b] < arrInput[b + 1])
                {
                    temp = arrInput[b];
                    arrInput[b] = arrInput[b + 1];
                    arrInput[b + 1] = temp;
                }
            }
        }
        sc.close();
        System.out.println("Sorted integers: ");
        for(a = 0; a < 4; a++)
            System.out.println(arrInput[a]);
    }
}

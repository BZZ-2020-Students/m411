package sorting_array;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
public class AufgabeB {

    private int[] unsortedArray;
    private final int SIZE = 50000;
    private final int RANGE = 100000000;


    public static void main(String[] args) {
        long startTime;

        AufgabeB aufgabeB = new AufgabeB();
        startTime = new Date().getTime();
        aufgabeB.sort();
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");
    }

    AufgabeB() {
        Random rand = new Random();
        unsortedArray = new int[SIZE];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(RANGE);
        }
    }

    private void sort() {
        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = 0; j < unsortedArray.length - 1; j++) {
                if(unsortedArray[i] >= unsortedArray[j]){
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[i];
                    unsortedArray[i] = temp;
                }
            }
        }
        System.out.println("Das fertig sortierte Array: " + Arrays.toString(unsortedArray));
    }
}

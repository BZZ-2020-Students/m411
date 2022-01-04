package sort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class legosort {

    private int[] unsortedArray;
    private final int SIZE = 50000;
    private final int RANGE = 100000000;


    public static void main(String[] args) {
        long startTime;

        legosort programm = new legosort();
        startTime = new Date().getTime();
        programm.sort();
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");
    }

    legosort() {
        Random rand = new Random();
        unsortedArray = new int[SIZE];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(RANGE);
        }
    }

    private void sort() {
        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = 0; j < (unsortedArray.length - 1-i); j++) {
                if (unsortedArray[j] <= unsortedArray[j + 1]) {
                    int speicher = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j+1];
                    unsortedArray[j+1] = speicher;
                }
            }
        }
        System.out.println(Arrays.toString(unsortedArray));
    }
}

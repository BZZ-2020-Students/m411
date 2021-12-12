package B1_Datentypen.Sortieren;

import java.util.Date;
import java.util.Random;

public class SortTemplate {
    private final int SIZE = 50000;
    private final int RANGE = 100000000;
    private int[] unsortedArray1;
    private int[] unsortedArray2;

    SortTemplate() {
        Random rand = new Random();
        unsortedArray1 = new int[SIZE];
        unsortedArray2 = new int[SIZE];
        for (int i = 0; i < unsortedArray1.length; i++) {
            int num = rand.nextInt(RANGE);
            unsortedArray1[i] = num;
            unsortedArray2[i] = num;
        }
    }

    public static void main(String[] args) {
        long startTime;

        SortTemplate programm = new SortTemplate();

        startTime = new Date().getTime();
        programm.sort();
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");

        startTime = new Date().getTime();
        programm.sortOptimized();
        System.out.println("Dauer der Sortierung (Optimiert): " + (new Date().getTime() - startTime) + "ms");
    }

    private void sort() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (unsortedArray1[j] < unsortedArray1[j + 1]) {
                    int temp = unsortedArray1[j];
                    unsortedArray1[j] = unsortedArray1[j + 1];
                    unsortedArray1[j + 1] = temp;
                }
            }
        }
    }

    private void sortOptimized() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < SIZE - 1; j++) {
                if (unsortedArray2[j] < unsortedArray2[j + 1]) {
                    int temp = unsortedArray2[j];
                    unsortedArray2[j] = unsortedArray2[j + 1];
                    unsortedArray2[j + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}

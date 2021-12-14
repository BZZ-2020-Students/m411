package Sortieren;

import java.util.Date;
import java.util.Random;

public class SortTemplate {
    private final int SIZE = 50000;
    private final int RANGE = 100000000;

    SortTemplate() {
        Random rand = new Random();
        int[] unsortedArray1 = new int[SIZE];
        int[] unsortedArray2 = new int[SIZE];
        int[] unsortedArray3 = new int[SIZE];
        int[] unsortedArray4 = new int[SIZE];
        for (int i = 0; i < unsortedArray1.length; i++) {
            int num = rand.nextInt(RANGE);
            unsortedArray1[i] = num;
            unsortedArray2[i] = num;
            unsortedArray3[i] = num;
            unsortedArray4[i] = num;
        }
        long startTime;

        startTime = new Date().getTime();
        bubbleSort(unsortedArray1);
        System.out.println("Dauer der bubble Sortierung: " + (new Date().getTime() - startTime) + "ms");

        startTime = new Date().getTime();
        bubbleSortOptimized(unsortedArray2);
        System.out.println("Dauer der bubble Sortierung (Optimiert): " + (new Date().getTime() - startTime) + "ms");

        startTime = new Date().getTime();
        Quicksort.quickSort(unsortedArray3);
        System.out.println("Dauer des Quicksorts: " + (new Date().getTime() - startTime) + "ms");

        startTime = new Date().getTime();
        Quicksort.quickSortRandomPivot(unsortedArray4);
        System.out.println("Dauer des Quicksorts (random pivot): " + (new Date().getTime() - startTime) + "ms");
    }

    public static void main(String[] args) {
        new SortTemplate();
    }

    private void bubbleSort(int[] unsorted) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (unsorted[j] < unsorted[j + 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
    }

    private void bubbleSortOptimized(int[] unsorted) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < SIZE - 1; j++) {
                if (unsorted[j] < unsorted[j + 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}

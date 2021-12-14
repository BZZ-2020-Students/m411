package Sortieren;

import java.util.Date;
import java.util.Random;

public class SortTemplate {
    private final int SIZE = 50000;

    SortTemplate() {
        Random rand = new Random();
        int[] unsortedArray1 = new int[SIZE];
        int[] unsortedArray2 = new int[SIZE];
        int[] unsortedArray3 = new int[SIZE];
        int[] unsortedArray4 = new int[SIZE];
        for (int i = 0; i < unsortedArray1.length; i++) {
            int RANGE = 100000000;
            int num = rand.nextInt(RANGE);
            unsortedArray1[i] = num;
            unsortedArray2[i] = num;
            unsortedArray3[i] = num;
            unsortedArray4[i] = num;
        }
        long startTime;
        long endTime;

        startTime = new Date().getTime();
        bubbleSort(unsortedArray1);
        endTime = new Date().getTime() - startTime;
        System.out.println("Dauer der bubble Sortierung: " + endTime + "ms");

        startTime = new Date().getTime();
        bubbleSortOptimized(unsortedArray2);
        endTime = new Date().getTime() - startTime;
        System.out.println("Dauer der bubble Sortierung (Optimiert): " + endTime + "ms");

        startTime = new Date().getTime();
        Quicksort.quickSort(unsortedArray3);
        endTime = new Date().getTime() - startTime;
        System.out.println("Dauer des Quicksorts: " + endTime + "ms");

        startTime = new Date().getTime();
        Quicksort.quickSortRandomPivot(unsortedArray4);
        endTime = new Date().getTime() - startTime;
        System.out.println("Dauer des Quicksorts (random pivot): " + endTime + "ms");
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

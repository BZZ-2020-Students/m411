package Sortieren;

import java.util.Date;
import java.util.Random;

public class SortTemplate {
    private int SIZE;

    SortTemplate() {
        int[] testSizes = {10, 100, 1000, 10000, 50000, 100000};
        for (int testSize : testSizes) {
            SIZE = testSize;

            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("Test grösse = " + SIZE);

            for (int i = 0; i < 4; i++) {
                Random rand = new Random();
                int[] unsortedArray = new int[SIZE];
                for (int j = 0; j < unsortedArray.length; j++) {
                    int RANGE = 100000000;
                    int num = rand.nextInt(RANGE);
                    unsortedArray[j] = num;
                }
                long startTime;
                long endTime;

                switch (i) {
                    case 0 -> {
                        startTime = new Date().getTime();
                        bubbleSort(unsortedArray);
                        endTime = new Date().getTime() - startTime;
                        System.out.println("Dauer der bubble Sortierung: " + endTime + "ms");
                    }
                    case 1 -> {
                        startTime = new Date().getTime();
                        bubbleSortOptimized(unsortedArray);
                        endTime = new Date().getTime() - startTime;
                        System.out.println("Dauer der bubble Sortierung (Optimiert): " + endTime + "ms");
                    }
                    case 2 -> {
                        startTime = new Date().getTime();
                        Quicksort.quickSort(unsortedArray);
                        endTime = new Date().getTime() - startTime;
                        System.out.println("Dauer des Quicksorts: " + endTime + "ms");
                    }
                    case 3 -> {
                        startTime = new Date().getTime();
                        Quicksort.quickSortRandomPivot(unsortedArray);
                        endTime = new Date().getTime() - startTime;
                        System.out.println("Dauer des Quicksorts (random pivot): " + endTime + "ms");
                    }
                }
            }
        }
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

package Sortieren;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] array = {4, 7, 2, 8, 9, 6, 1, 3};
        System.out.println("array = " + Arrays.toString(array));
        quickSortRandomPivot(array);
        System.out.println("array sorted = " + Arrays.toString(array));
    }

    public static void quickSort(int[] unsorted) {
        sort(unsorted, 0, unsorted.length - 1);
    }

    public static void quickSortRandomPivot(int[] unsorted) {
        sortRandomPivot(unsorted, 0, unsorted.length - 1);
    }

    private static int split(int[] array, int left, int right) {
        return split(array, left, right, array[right]);
    }

    private static int splitRandomPivot(int[] array, int left, int right) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(left, right + 1);
        swap(array, pivotIndex, right);
        return split(array, left, right, array[right]);
    }

    private static int split(int[] array, int left, int right, int pivot) {
        int i = left;
        int j = right - 1;

        while (i < j) {
            while (i < right && array[i] < pivot) {
                i++;
            }
            while (j > left && array[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        if (array[i] > pivot) {
            swap(array, i, right);
        }
        return i;
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int split = split(array, left, right);
            sort(array, left, split - 1);
            sort(array, split + 1, right);
        }
    }

    private static void sortRandomPivot(int[] array, int left, int right) {
        if (left < right) {
            int split = splitRandomPivot(array, left, right);
            sortRandomPivot(array, left, split - 1);
            sortRandomPivot(array, split + 1, right);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

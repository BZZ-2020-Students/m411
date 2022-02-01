package quicksort;

import rekursion_A02.Rekursion;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class quicksort {
    private int[] unsortedArray;
    private final int SIZE =10;
    private final int RANGE = 10;


    public static void main(String[] args) {
        long startTime;

        quicksort programm = new quicksort();
        startTime = new Date().getTime();
        System.out.println(Arrays.toString(programm.unsortedArray));
        programm.sort(programm.unsortedArray,0,programm.unsortedArray.length-1);
        System.out.println("programm.unsortedArray = " + Arrays.toString(programm.unsortedArray));
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");
    }

    quicksort() {
        Random rand = new Random();
        unsortedArray = new int[SIZE];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(RANGE);
        }
    }

    private void sort(int[] arr,int links,int rechts) {
        if(links < rechts) {
            int split = teile(arr,links, rechts);
            sort(arr,links, split - 1);
            sort(arr,split + 1, rechts);
        }

    }

    private int teile(int[] arr,int links,int rechts){
        int i = links;
        // Starte mit j links vom Pivotelement
        int j = rechts - 1;
        int pivot = arr[rechts];

        while (i < j) { // solange i an j nicht vorbeigelaufen ist
            // Suche von links ein Element, welches größer oder gleich dem Pivotelement ist
            while(i<rechts && arr[i] < pivot) {
                i=i + 1;
            }

            // Suche von rechts ein Element, welches kleiner als das Pivotelement ist
            while (j > links && arr[j] >=pivot) {
                j=j - 1;
            }

            if (i <j) {
                swap(arr,i, j);
            }


        }


        // Tausche Pivotelement (daten[rechts]) mit neuer endgültiger Position (daten[i])
        // und gib die neue Position des Pivotelements zurück, beende Durchlauf
        if (arr[i] > pivot) {
            swap(arr,i,rechts);
        }
        return i;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



}


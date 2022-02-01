package quicksort;

import java.util.Date;
import java.util.Random;

public class Bubblesort {

    private int[] unsortedArray;
    private final int SIZE = 100000;
    private final int RANGE = 100000000;


    public static void main(String[] args) {
        long startTime;

        Bubblesort programm = new Bubblesort();
        startTime = new Date().getTime();
        programm.sort();
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");
    }

    public Bubblesort() {
        Random rand = new Random();
        unsortedArray = new int[SIZE];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(RANGE);
        }
    }

    private void sort() {

    	 for(int a = 0; a < unsortedArray.length - 1; a++){
            for(int b = 0; b < unsortedArray.length - a - 1; b++){
               if(unsortedArray[b] > unsortedArray[b + 1]){
                  int temp = unsortedArray[b];
                  unsortedArray[b] = unsortedArray[b + 1];
                  unsortedArray[b + 1] = temp;
               }
            }
         }
    }
}

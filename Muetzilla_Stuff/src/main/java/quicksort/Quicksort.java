package quicksort;

import java.util.Random;

public class Quicksort {
    private int []arrayToSort = {4,7,2,8,9,6,1,3};
    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
    }
    public Quicksort(){
        int pivot = arrayToSort[new Random().nextInt(arrayToSort.length)];

    }


}

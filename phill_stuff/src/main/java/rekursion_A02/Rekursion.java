package rekursion_A02;

import java.util.*;

public class Rekursion {
    public static void main(String[] args) {
        Rekursion programm = new Rekursion();



    }

    private void rekursion(int i){
        i++;
        System.out.println(i);
        if (i != 5){
            rekursion(i);
        }
    }
}

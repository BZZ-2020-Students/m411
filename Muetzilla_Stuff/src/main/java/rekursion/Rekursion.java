package rekursion;

public class Rekursion {
    public static void main(String[] args) {
        Rekursion rekursion = new Rekursion();
        System.out.println("Aufgabe A");
        rekursion.rekursionAufgabeA(5);
        System.out.println("Augabe B");
        rekursion.rekursionAufgabeB(0);
    }

    //Aufgabe A
    private void rekursionAufgabeA(int i){
        i--;
        System.out.println(i);
        if(i != 0){
            rekursionAufgabeA(i);
        }
    }

    //Aufgabe B
    private void rekursionAufgabeB(int i){
        i++;
        System.out.println(i);
        if(i != 5){
            rekursionAufgabeB(i);
        }
    }
}

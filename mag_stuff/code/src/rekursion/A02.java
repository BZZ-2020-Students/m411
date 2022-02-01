package rekursion;

public class A02 {
    public static void main(String[] args) {
//        new A02().rekursion(5);
        new A02().rekursionRev(0);
    }

    public void rekursionRev(int i){
        i++;
        System.out.println(i);
        if(i != 5)
            rekursionRev(i);
    }

    public void rekursion(int i){
        i--;
        System.out.println(i);
        if(i != 0)
            rekursion(i);
    }
}

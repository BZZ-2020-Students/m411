package rekursion;

public class Rekursion {
    public static void main(String[] args) {
        Rekursion rekursion = new Rekursion();
        rekursion.rekursionForward(0, 5);
    }

    private void rekursionBackwards(int i) {
        i--;
        System.out.println(i);
        if (i != 0) {
            rekursionBackwards(i);
        }
    }

    private void rekursionForward(int i, int target) {
        i++;
        System.out.println(i);
        if (i < target) {
            rekursionForward(i, target);
        }
    }
}

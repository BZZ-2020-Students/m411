package pruefig;

public class Pseudo {
    public static void main(String[] args) {
        new Pseudo().run();
    }

    public void run(){
        int n = 5;
        int ergebnis = 1;
        if(n > 0){
            for (int i = 1; i < n; i++){
                ergebnis = ergebnis * i;
                System.out.println(ergebnis);
            }
        }

    }
}

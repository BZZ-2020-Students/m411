package LB01;

public class ZahlenSorter {
    public static void main(String[] args) {
        // Declare local variables here

        // Initialise local variables here

        int[] zahlen = new int[4];
        zahlen[0] = 23;
        zahlen[1] = 56;
        zahlen[2] = 1;
        zahlen[3] = 213;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (zahlen[j] < zahlen[j + 1]) {
                    int temp = zahlen[j];
                    zahlen[j] = zahlen[j + 1];
                    zahlen[j + 1] = temp;
                }
            }
        }

        StringBuilder ausgabe = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ausgabe.append(zahlen[i]);
            if (i < 3) {
                ausgabe.append(" - ");
            }
        }
        System.out.println("ausgabe = " + ausgabe);
    }
}

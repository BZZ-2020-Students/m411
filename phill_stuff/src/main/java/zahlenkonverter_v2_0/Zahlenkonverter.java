package zahlenkonverter_v2_0;

public class Zahlenkonverter {
    private Einleser einleser;
    private String natuerlichezahl = "";
    private String umgewandelteNummerHex = "";
    private String umgewandelteNummerBIN = "";

    public Zahlenkonverter(){
        einleser = new Einleser();
    }

    public String Usereingaben(){
        System.out.println("Wilkommen beim Zahlenkonverter");
        System.out.println("Geben Sie eine Zahl ein");
        natuerlichezahl = einleser.readString();
        return natuerlichezahl;
    }

    public void convert(String zuconverten){

    }

    public void printAllNumbers(){
        System.out.println("Natürliche Zahl: " + natuerlichezahl);
        System.out.println("Hex: " + umgewandelteNummerHex);
        System.out.println("BIN: " + umgewandelteNummerBIN);
    }




}

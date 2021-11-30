package zahlenkonverter_v2_0;


import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class Zahlenkonverter {
    private Einleser einleser;
    private String natuerlichezahl = "";
    private String divider = "";
    private String umgewandelteNummerHex = "";
    private String umgewandelteNummerBIN = "";

    public Zahlenkonverter(){
        einleser = new Einleser();
    }

    public void Usereingaben(){
        System.out.println("Wilkommen beim Zahlenkonverter");
        System.out.println("Geben Sie eine Zahl ein");
        natuerlichezahl = einleser.readString();
        System.out.println("Wie soll umgewandelt werden? [BIN = 2 | HEX = 16]");
        divider = einleser.readString();
        if (divider.equals("2")){
            bin();
        }else if(divider.equals("16")){
            hex();
        }
    }

    public void bin(){
        System.out.println("BIN");
        StringBuilder result = new StringBuilder();
        float interimresult = Float.parseFloat(natuerlichezahl);
        float dividerF = Float.parseFloat(divider);
        List<Integer> remainder = new ArrayList<Integer>();
        do{
            interimresult = interimresult / dividerF;
            if (interimresult % 1 == 0){
                remainder.add(0);
            }else{
                remainder.add(1);
            }
            interimresult = (int)interimresult;
        }while (interimresult != 0);


        for (int i = remainder.size() - 1; i >= 0; i--) {
            result.append(Integer.toString(remainder.get(i)));
        }
        umgewandelteNummerBIN = result.toString();
        umgewandelteNummerHex = "-";
    }

    public void hex(){
        System.out.println("HEX");
        StringBuilder result = new StringBuilder();
        float interimresultint = Float.parseFloat(natuerlichezahl);
        float dividerF = Float.parseFloat(divider);
        List<Integer> remainder = new ArrayList<Integer>();

        do{
            float interimresult = interimresultint / dividerF;
            remainder.add((int)((interimresult - Integer.valueOf((int) interimresult).floatValue())*16));
            interimresultint = (int)interimresult;
        }while (interimresultint != 0);


        for (int i = remainder.size() - 1; i >= 0; i--){

            if (remainder.get(i) > 9) {
                result.append((char) (65 + (remainder.get(i) - 10)));
            }else{
                result.append(remainder.get(i));
            }
        }
        umgewandelteNummerBIN = "-";
        umgewandelteNummerHex = result.toString();
    }

    public void printAllNumbers(){
        System.out.println("Natürliche Zahl: " + natuerlichezahl);
        System.out.println("Hex: " + umgewandelteNummerHex);
        System.out.println("BIN: " + umgewandelteNummerBIN);
    }




}

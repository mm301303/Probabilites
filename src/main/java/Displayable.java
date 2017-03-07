import javax.sound.midi.Soundbank;

/**
 * Created by maxime on 02/03/17.
 */
public interface Displayable {
    static String title_prefix = " [ * [ ";
    static String body_prefix = " [\t* [ ";
    static String closure = " ]] ";

    static void PrintLine(String s){
        System.out.println(body_prefix+s+closure);
    }
    static void PrintTitle(String s){
        System.out.println(title_prefix+"\t"+s+"\t"+closure);
    }

    static void display(Law law, int x_egal_i){
        PrintLine("*****");

            PrintTitle(law.getName());
            PrintLine(law.getParameters());

            if (law.getVariance() != -1)
                PrintLine("VARIANCE = " + String.format("%.3f", law.getVariance()));

            if (law.getEsperance() != -1)
                PrintLine("ESPERANCE = " + String.format("%.3f", law.getEsperance()));

            PrintLine("P(X=" + x_egal_i + ") = " + String.format("%.3f", law.getProbabiliteDeX(x_egal_i)));
            details(law, x_egal_i);
        if(law instanceof ContinuousLaw) {
            System.out.println("displayContinuousLaw advised");
        }
        PrintLine("*****");
    }
    static void displayContinuousLaw(Law law, double a, double b){

        if(law instanceof ContinuousLaw){
            PrintTitle(law.getName());
            PrintLine(law.getParameters());
            PrintLine("DENSITY[ "+a+" ; "+b+" ] = "+String.format("%.3f",((ContinuousLaw) law).density(a,b)));
        }

    }
    static void details(Law law, int until){
        PrintLine("-----------------------------------------");
        for(int i=0; i<until; i++)
            PrintLine("* P(X="+i+") = \t"+law.getProbabiliteDeX(i)+" ");
        PrintLine("-----------------------------------------");
    }

    String getName();
}

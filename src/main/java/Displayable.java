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
        PrintTitle(law.getName());
        PrintLine(" p = "+String.format("%.3f",law.getPsuccess())+"\t non(p) = "+String.format("%.3f",new Double(1-law.getPsuccess())));
        PrintLine("VARIANCE = "+String.format("%.3f",law.getVariance()));
        PrintLine("ESPERANCE = "+String.format("%.3f",law.getEsperance()));
        PrintLine("P(X="+x_egal_i+") = "+String.format("%.3f",law.getPrecomputedValForX(x_egal_i)));
        PrintLine("*****");
        details(law);
        PrintLine("*****");
    }
    static void details(Law law){
        PrintLine("Loi complete : "+law.compute());
    }

    /**
     * should be used wit this
     * @param law
     */
    static void displayComputation(Law law){
        law.compute();
    }
    String getName();
}

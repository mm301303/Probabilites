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
        PrintLine("VARIANCE = "+String.format("%.3f",law.getVariance()));
        PrintLine("ESPERANCE = "+String.format("%.3f",law.getEsperance()));
        PrintLine("P(X="+x_egal_i+") = "+String.format("%.3f",law.compute(x_egal_i)));
        details(law, x_egal_i);
        PrintLine("*****");
    }
    static void details(Law law, int until){
        PrintLine("-----------------------------------------");
        for(int i=0; i<until; i++)
            PrintLine("* P(X="+i+") = \t"+law.compute(i)+" ");
        PrintLine("-----------------------------------------");
    }

    String getName();
}

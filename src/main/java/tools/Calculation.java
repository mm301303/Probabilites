package tools;

/**
 * Created by maxime on 09/03/17.
 */
public class Calculation {

    public static long factorielle(int n){
        if(n<=1) return 1;
        return n*factorielle(n-1);
    }

    public static double kParmisN(int k, int n) {
        return factorielle(n)/(factorielle(k)*factorielle(n-k));
    }

}

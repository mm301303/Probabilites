package tools;

import Exceptions.CalculationException;

/**
 * Created by maxime on 09/03/17.
 */
public class Calculation {

    public static final double DELTA = 0.0001;

    public static double factorielle(int n) throws CalculationException {
        double res = 1;
        for(int i=n; i>=1;i--)res*=i;
        return res;
    }


    public static double kParmisN(int k, int n) throws CalculationException {
        if(k>n || k<0) return 0;
        if(k==0 || k==n) return 1;
        if(k==1) return n;
        if(k>=2 && n>k) {
            /*double num = factorielle(n);
            double denom = factorielle(k) * factorielle(n - k);
            double coef = num / denom;
            return coef;*/
            //on peut simplifier par (n, n-k) = (n, k) = (n , k - 1) * [n+k+1/k]
            return kParmisN(k-)
        }else {
            throw new CalculationException(k, n);
        }
    }

}

package tools;

import Exceptions.CalculationException;

/**
 * Created by maxime on 09/03/17.
 */
public class Calculation {

    public static double factorielle(int n) throws CalculationException {
        double res = 1;
        for(int i=n; i>=1;i--)res*=i;
        return res;
    }


    public static double kParmisN(int k, int n) throws CalculationException {
        if(n==k) return 1;
        if(k==0) return 1;
        if(k==1) return n;
        if(k>=2 && n>k) {
            double num = factorielle(n);
            double denom = factorielle(k) * factorielle(n - k);
            double coef = num / denom;
            return coef;
        }else {
            throw new CalculationException(k, n);
        }
    }

}

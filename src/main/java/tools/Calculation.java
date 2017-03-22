package tools;

import Exceptions.CalculationException;
import Laws.NormaleLaw;
import Laws.functions.ContinuousLaw;

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
            double num = factorielle(n);
            double denom = factorielle(k) * factorielle(n - k);
            double coef = num / denom;
            return coef;
            //on peut simplifier par (n, n-k) = (n, k) = (n , k - 1) * [n+k+1/k]
            //TODO
            /*if(n-k<k) return kParmisN(n-k, n );

            return kParmisN(k-1,n)*(n+k+1)/(double)k;*/
        }else {
            throw new CalculationException(k, n);
        }
    }

    public static double approximationDintegrale(double borneInf, double borneSup, ContinuousLaw nl){
        double surface = 0;
        double dx=0;
        double x=1;
        double coef = Math.abs(borneSup-borneInf);
        double n=(coef>10)?10000*coef:10000;//parametre
        // Détermination du dx
        dx = 1./n;
        for( x=borneInf ; x<=borneSup ; x+=dx )
        {
            // Calcul de l'aire de chaque petit rectangle que l'on ajoute à la surface totale
            surface += nl.f(x)*dx;
        }
        return surface;
    }

    public static double integraleParSimpson(double borneInf, double borneSup, ContinuousLaw nl){

        int n = 600000;
        double sections = n/3;
        double h = (borneSup-borneInf)/n;
        double approx =0;

        double x0, x1, x2, x3;
        for(int i =1 ; i<sections+1; i++){
            x0 = borneInf + 3.*(i-1)*h;
            x1 = x0 + h;
            x2 = x1 + h;
            x3 = x2 + h;
            approx += nl.f(x0) + 3.*nl.f(x1) + 3.*nl.f(x2) + nl.f(x3);
        }
        double res = 3*(h/8.)*approx;

        return res;
    }
}

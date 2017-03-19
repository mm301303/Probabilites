package tools;

import Exceptions.CalculationException;
import Laws.NormaleLaw;

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

    public static double approximationDintegrale(double borneInf, double borneSup, NormaleLaw nl){
        double surface = 0;
        double dx=0;
        double x=0;
        int n=10000;//parametre

        System.out.println("En combien de parties voulez-vous decouper l'intervalle [1,4]? ");
        // Détermination du dx
        dx = 1./n;
        // On intègre de 1 a 4 avec un pas de dx
        for( x=borneInf ; x<borneSup ; x+=dx )
        {
            // Calcul de l'aire de chaque petit rectangle que l'on ajoute à la surface totale
            surface += nl.f(x)*dx;
        }
        return surface;
    }

}

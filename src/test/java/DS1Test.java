import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import com.sun.deploy.cache.Cache;
import org.junit.Ignore;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.assertEquals;

/**
 * Created by max on 07/03/17.
 */
public class DS1Test {
    double delta =0.001;
    @Test
    public void Question2DS1Test() throws Exception, LawException {
        System.out.println("\nQuestion2DS1Test");
        double psucess = 1./9.;
        System.out.println("quelles est le nombre minimal de lancer d'un dé équillibré a 9 faces\n"+
                "pour avoir au moins 60% de chance d'obtenir au moins une fois la valeur du premier lancers");
        GeometricLaw geoLaw = new GeometricLaw(psucess);

        double proba =0.;
        int i;
        for(i=1; proba<0.6;i++) {
            proba += geoLaw.getProbabiliteDeX(i);
            System.out.println("proba = " + proba + "au "+ i+"+1 eme lancer");

        }

        System.out.println("au bout de " + (i-1)+ " lancers on a 60% d'avoir une valeur déterminée a l'avance du dé, on aura lancé "+ (int)(i)+ " fois le dé" );

        assertEquals(9, i);
        System.out.println("\n");
    }
    @Test
    @Ignore
    public void Question3DS1Test() throws Exception, LawException, CalculationException {
        double res = 0;
        System.out.println("\nQuestion3DS1Test");
        System.out.println("Jeu de carte a 3 couleurs, 30 cartes, à valeur entre 1 et 10\n"+
        "On tire 5 cartes quelle est la proba d'obtenir trois cartes de même valeur ?");
        res = ((Calculation.kParmisN(1,30)*1.)/30.)
                +((Calculation.kParmisN(1,27)*1)/29.)
                +((Calculation.kParmisN(1,24)*1)/28.);
        System.out.println("P(X=3) = " + res);
        assertEquals(68./2639., res,delta);

    }

}
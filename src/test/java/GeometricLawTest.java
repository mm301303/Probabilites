import Exceptions.LawException;
import Laws.GeometricLaw;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by maxime on 02/03/17.
 */
public class GeometricLawTest {
    double delta = 0.01;
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


}
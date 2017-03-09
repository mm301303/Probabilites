import Exceptions.CalculationException;
import Exceptions.LawException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 09/03/17.
 */
public class BinomialeLawTest {
    double delta = 0.001;
    @Test
    public void TD1exo21() throws Exception, LawException, CalculationException {
        // P qu’il ait au moins un garçon ?
        Law law = new BinomialeLaw(0.5, 2);
        System.out.println("Le voisin a deux enfants\nP qu’il ait au moins un garçon ?");
        double res = 0;
        for(int X=1; X<=2; X++) res+= law.getProbabiliteDeX(X);
        System.out.println("res = " + res);
        assertEquals(3./4., res, delta);
        System.out.println("Quelle est la probabilité qu’il ait un garçon, sachant que l’aînée est une fille ?");
        law = new BinomialeLaw(0.5,1);
        res = law.getProbabiliteDeX(1);
        System.out.println("res = " + res);
        assertEquals(0.5, res, delta);
    }

    @Test
    public void TD1exo26() throws Exception, LawException, CalculationException {
        System.out.println("medicament qui provoque une allergie a 1 personne sur 100");
        System.out.println("probabilité d'au moins une allergie sur 70 patients ?");
        BinomialeLaw law = new BinomialeLaw(0.01, 70);
        double res = 0;
        for(int X=1; X<=70; X++) {
            res+= law.getProbabiliteDeX(X);
        }
        System.out.println("res = " + res);

        assertEquals(50.51/100.0, res, delta);
    }



}
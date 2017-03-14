package Laws;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 14/03/17.
 */
public class ExponentialLawTestTD2 {
    @Test
    @Ignore //while not finished
    public void exo7TD2(){
        /**
         * la duree de transmission d'un mess suit une loi exponentielle de parametre 1
         * Calculez :
         * la proba que la durée soit entre 0 et 1
         */
        ExponentialLaw el = new ExponentialLaw(1);
        double resultat = el.density(0.,1.);
        System.out.println("resultat = density(0.,1.) = " + resultat);
        /**
         * quelle est la proba de dix messages et que les 10 prennent moins de 3 secondes ?
         */


    }
}
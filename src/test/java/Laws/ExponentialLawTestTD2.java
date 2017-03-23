package Laws;

import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by max on 14/03/17.
 */
public class ExponentialLawTestTD2 {
    double delta = Calculation.DELTA;
    @Test
    public void exo7TD2(){
        System.out.println("\nexo7TD2\n");
        /**
         * la duree de transmission d'un mess suit une loi exponentielle de parametre 1
         * Calculez :
         * la proba que la durée soit entre 0 et 1
         */
        ExponentialLaw el = new ExponentialLaw(1);

        double resultat = el.f(1.,2.);

        System.out.println("resultat = f(1.,2.) = " + resultat);
        assertEquals(0.2325, resultat, delta);
        assertEquals(0.2325, el.F(1.,2.), delta);
        /**
         * quelle est la proba de dix messages et que les 10 prennent moins de 3 secondes ?
         */
        //P(X<3)
        double p2 = el.f(0.,3.);
        System.out.println("p2 = f(0.,3.) = " + p2);
        assertEquals(0.95021, p2, delta);

        double p3 = 1;
        for(int i=0; i<10;i++) p3 *= el.f(0.,3.);

        System.out.println("la proba de dix messages et que les 10 prennent moins de 3 secondes est :\n" +
                "f(0.,3.)^10");

        System.out.println("Temps total moyen = 10 * 1/1 s");

        assertEquals(0.6001, p3, delta);


    }
}
package old;

import Laws.PoissonLaw;
import Laws.functions.Law;
import org.junit.Before;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by maxime on 06/03/17.
 */
public class PoissonLawTest {
    private double delta= Calculation.DELTA;
    private PoissonLaw poisson;
    double lambda;


    @Test
    public void getName() throws Exception {
        poisson = new PoissonLaw(5.);
        assertEquals("Poisson Laws.functions.Law", poisson.getName());
    }
    @Test
    public void exo33TD1(){
        System.out.println("\nexo33TD1");
        System.out.println("\nexo sur le nombre d'avions dans un aéroport pour une loi de poisson de paramètre lambda");
        System.out.println("on veut savoir la proba d'avoir moins de 3 avions en un jour");
        lambda = 3;
        poisson = new PoissonLaw(3);
        double res = 1.- poisson.getProbabiliteDeX(2)-poisson.getProbabiliteDeX(1) - poisson.getProbabiliteDeX(0);
        System.out.println("1-poisson.getProbabiliteDeX(2)-poisson.getProbabiliteDeX(1) = " + res);
        assertEquals(0.5768, res, delta);
    }

}
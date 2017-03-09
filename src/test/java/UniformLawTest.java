import org.apache.commons.math3.analysis.UnivariateFunction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 07/03/17.
 */
public class UniformLawTest {

    @Test
    public void exo1TD1(){//corrected
        double borneInfU = 0;
        double borneSuppU = 30;

        UniformLaw uniformLaw = new UniformLaw(borneInfU, borneSuppU);

        System.out.println("Attendre moins de 5 min :");
        double res5 = uniformLaw.density(10,15) + uniformLaw.density(25,30);
        System.out.println("uniformLaw.density(10,15) + uniformLaw.density(25,30) = " + res5);
        assertEquals(1./3., res5,0.01);

        System.out.println("Attendre moins de 10 min :");
        double res5_2 = uniformLaw.density(5,10) + uniformLaw.density(20,25);
        System.out.println("uniformLaw.density(5,10) + uniformLaw.density(20,25) = " + res5_2);
        assertEquals(1./3., res5_2,0.01);
        System.out.println("resultat r1+r2 = " + (double)(res5_2+res5));

        assertEquals(2./3., res5+res5_2,0.01);

    }

    @Test
    public void exo2TD1() {

        double et =  Math.sqrt(48.0);
        double inf = 4.0 - et/2;
        double supp = 4.0 + et/2;
        UniformLaw ul = new UniformLaw(inf,supp);
        System.out.println("ul.getEsperance() = " + ul.getEsperance());
        assertEquals(4., ul.getEsperance(), 0.01);
        System.out.println("ul.getVariance() = " + ul.getVariance());
        assertEquals(4., ul.getVariance(), 0.01);

    }
}
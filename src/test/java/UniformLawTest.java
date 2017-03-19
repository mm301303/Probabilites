import Laws.UniformLaw;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by max on 07/03/17.
 */
public class UniformLawTest {
    double delta = Calculation.DELTA;
    @Test
    public void exo1TD1(){//corrected
        System.out.println(this.getClass().getSimpleName()+" exo1TD1");
        double borneInfU = 0;
        double borneSuppU = 30;

        UniformLaw uniformLaw = new UniformLaw(borneInfU, borneSuppU);

        System.out.println("Attendre moins de 5 min :");
        double res5 = uniformLaw.f(10,15) + uniformLaw.f(25,30);
        System.out.println("uniformLaw.f(10,15) + uniformLaw.f(25,30) = " + res5);
        assertEquals(1./3., res5,0.01);

        System.out.println("Attendre moins de 10 min :");
        double res5_2 = uniformLaw.f(5,10) + uniformLaw.f(20,25);
        System.out.println("uniformLaw.f(5,10) + uniformLaw.f(20,25) = " + res5_2);
        assertEquals(1./3., res5_2,0.01);
        System.out.println("resultat r1+r2 = " + (double)(res5_2+res5));

        assertEquals(2./3., res5+res5_2,0.01);

    }

    @Test
    public void exo2TD1() {
        System.out.println("exo2TD1");
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
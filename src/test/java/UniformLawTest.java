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
        assertEquals(1./3., res5);

    }

    @Test
    public void exo2TD1() {
        //trouver une loi uniforme qui fasse qu'on aie la meme espérance et variance qu'un dé a 7 faces
        //pour un dé a 7 face, E(D7) = 1+2+3+4+5+6+7/7 = 4
        //                      V(D7)=4
        //Loi uniforme : E(U) = a+b/2 et V(U)=(b-a)^2 /12
        //on veut a+b=8 et (a+b)^2/12 = 4
        // -> (b-a)^2 = 4*12 = 48 = 4sqrt(3)
        //d'ou la loi uniforme sur [4-2squrt(3);4+2squrt(3)]
        //correction :
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
package Laws;

import Exceptions.CalculationException;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by maxime on 19/03/17.
 */
public class NormaleLawTest {

    @Test
    public void exo10TD2() throws CalculationException {
        System.out.println("On suppose que la taille en centimètres d’un humain mâle de 25 ans suit une loi aléatoire normale de\n" +
                "paramètre μ = 175 et σ = 6.\n" +
                "Quel est le pourcentage des hommes de 25 ans ayant une taille supérieure à 185 cm ?");
        NormaleLaw law = new NormaleLaw(175, 36);
        double res = law.F(149., 185.);
        System.out.println("res = " + res);
        assertEquals(4.746,res, Calculation.DELTA);
        System.out.println("Parmi les hommes mesurant plus de 180 cm quel pourcentage mesure plus de 192 cm ?");



    }

}
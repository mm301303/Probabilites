package Laws;

import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by maxime on 19/03/17.
 */
public class NormaleLawTest {

    @Test
    public void exo10TD2(){
        System.out.println("On suppose que la taille en centimètres d’un humain mâle de 25 ans suit une loi aléatoire normale de\n" +
                "paramètre μ = 175 et σ = 6.\n" +
                "Quel est le pourcentage des hommes de 25 ans ayant une taille supérieure à 185 cm ?\n" +
                "Parmi les hommes mesurant plus de 180 cm quel pourcentage mesure plus de 192 cm ?");
        System.out.println("res = 1. - law.density(185) = " + res+"%");
    }

}
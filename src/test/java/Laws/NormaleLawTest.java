package Laws;

import Exceptions.CalculationException;
import org.junit.Test;
import tools.Calculation;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by maxime on 19/03/17.
 */
public class NormaleLawTest {
    //need to find an impl for normaleLaw, maybe in apache common maths

    @Test
    public void exo10TD2() throws CalculationException {
        System.out.println("On suppose que la taille en centimètres d’un humain mâle de 25 ans suit une loi aléatoire normale de\n" +
                "paramètre μ = 175 et σ = 6.\n" +
                "Quel est le pourcentage des hommes de 25 ans ayant une taille supérieure à 185 cm ?");
        NormaleCenteredReducedLaw law = new NormaleCenteredReducedLaw();

        double res = law.F(-3./5.);//Avec La NCRL ca marche
        System.out.println("res = " + res);
        assertEquals(4.746,res, Calculation.DELTA);
        System.out.println("Parmi les hommes mesurant plus de 180 cm quel pourcentage mesure plus de 192 cm ?");

    }

    @Test
    //TODO
    public void exo11TD2() throws CalculationException {
        System.out.println("L'intervalle de temps exprimé ->en heures<- entre deux redémarrages intempestifs d'une certaine machine ayant un certain OS\n"
                +"suit une loi normale esperance = 3 et variance = 4\n"+
                "on démarre un td de deux heures dans une salle ou il y a 20 machines fraichement rebootées en début de td\n"
                +"quelle est la proba que le td puisse se terminer sans qu'il y ait de redémarrage ?");

        NormaleCenteredReducedLaw law = new NormaleCenteredReducedLaw();
        double res1 =  law.F_de_p_superieur_a(0-3/4);
        System.out.println("Pour une machine res = 1-law.F(-1, 0) = "+res1);
        double res20 = Math.pow(res1,20);
        System.out.println("Pour 20 machines res = Math.pow(res1,20) = "+res20);
        assertEquals(69.146/100,res1,Calculation.DELTA);
        assertEquals(0.69146,res1,Calculation.DELTA);
        assertEquals(0.1708,res20,Calculation.DELTA);



    }

}
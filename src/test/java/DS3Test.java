import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.NormaleLaw;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by max on 09/03/17.
 */
public class DS3Test {
    @Test
    public void question1() throws CalculationException {
        System.out.println("Les notes de la classes sont réparties entre 6 et 17");
        System.out.println("avec une moyenne de 11");
        System.out.println("On choisit un eleve au hasard, truver la meilleur borne pour que cet élève ait une");
        System.out.println("note >=13");

        NormaleLaw law = new NormaleLaw(11., 5.);
        double res = law.F_de_p_superieur_a(13);
        System.out.println("res = " + res);
    }


}
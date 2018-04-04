package TD4_MIAGE;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BinomialeLaw;
import Laws.functions.Law;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.assertEquals;
import static tools.Displayable.closure;
import static tools.Displayable.title_prefix;

/**
 * On admet que la probabilité de défaut pour un objet fabriqué à la machine est égale à 0, 1. On
 * considère un lot de 10 objets fabriqués par cette machine. Soit X le nombre d’objets défectueux
 * parmi ceux-ci.
 */

public class TD4S6_exercice3 {

    private final int N=10;
    private int X;
    //a)
    /*La variable X compte le nombre d’objets qui ont une certaine propriété (être défectueux),
    en en considérant 10 au total. C’est donc qu’on répète 10 fois l’expérience de tester des
    objets. X suit donc une loi binomiale de paramètres n = 10 et p = 0, 1, puisque la
    probabilité d’être défectueux pour un objet vaut 0, 1.*/
    @Test
    public void parametres() throws LawException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("b)");
        BinomialeLaw b = new BinomialeLaw( N, 0.1);
        double esp = b.getEsperance();
        double var = b.getVariance();

        assertEquals(1, esp, 0.01);
        assertEquals(0.9, var, 0.01);
        System.out.println(closure);
    }
    //Quelle est la probabilité que le lot comprenne au moins 2 objets défectueux ?
    @Test
    public void auMoinsDeuxDeffectueux() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("c)");
        BinomialeLaw b = new BinomialeLaw(N, 0.1);

        //soit E=P(X>=2), soit A=P(X<=1)

        double A = b.getProbabiliteDeX(0)+b.getProbabiliteDeX(1);

        Law.printcalcul("P(X>=2)", "1-P(X<=1) \n= 1 - b.getProbabiliteDeX(0)+b.getProbabiliteDeX(1) = "+(1.-A));
        assertEquals(1.-(1./9.)*(Math.pow(0.9, 9)), 1.- A, 0.0001);
        System.out.println(closure);
    }
}

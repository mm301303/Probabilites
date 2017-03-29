import Exceptions.CalculationException;
import Laws.ExponentialLaw;
import Laws.NormaleCenteredReducedLaw;
import Laws.NormaleLaw;
import Laws.UniformLaw;
import Properties.CentralLimitTheorem;
import Properties.Markov;
import Properties.Tchebychev;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import tools.Calculation;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * approximation are really bad due to a minimalist implementation of mathematical models...
 */
public class TD3Test {
    @Test
    public void ex2() throws CalculationException {
        double moy=65., s=5.;
        System.out.println("\nExercice 2");
        System.out.println("65 de moyenne a un examen, s=5, donnez la proportion d'etudiants entre 45 et 85");
        assertEquals(0.0625, Tchebychev.inequality(5,20), Calculation.DELTA);
        System.out.println("selon Tchebychev : "+Tchebychev.inequality(5,20));

        System.out.println("\nPar la loi uniforme :");
        System.out.println("on doit calculer la borne inf et supp");
        System.out.println("Par la loi uniforme sur un intervalle de longeur lambda on a V(X)=lambda^2 / 12");

        double var_x = s*s;
        double lambda = Math.sqrt(12.*25.);
        assertEquals(17.32, lambda, 0.001);
        System.out.println("lambda = "+lambda);
        System.out.println("donc pour une longueur lambda : [65-lambda/2;65+lambda/2]");
        UniformLaw law = new UniformLaw(moy-lambda/2, moy+lambda/2);
        assertEquals(1., law.F(45,85), 0.001 );
        System.out.println("Par la loi uniforme sur un intervalle de longeur lambda la proportion d'etudiants entre 45 et 85 vaut " +law.F(45,85));
        System.out.println("\nPar la loi normale :");
        NormaleLaw normaleLaw = new NormaleLaw(moy, s*s);
        double res = 1.-(2.*normaleLaw.F(45));
        //TODO Fix
        assertEquals(0.999937, res, Calculation.DELTA );
        System.out.println("Par la loi normale la proportion d'etudiants entre 45 et 85 vaut " +res);

    }

    @Test
    public void ex3() throws CalculationException {
        double moy=10.;
        System.out.println("\nExercice 3");
        System.out.println("Soit X une variable aléatoire à valeur positive d’espérance\n" +
                "E(X) = 10");
        System.out.println("Trouver une borne inférieure pour P(X<20)");
        System.out.println("Par Markov:");
        double res = Markov.P_x_sup_a_y_inferieur_a(moy, 20);
        System.out.println("res = " + res);

        assertEquals(0.5, res,Calculation.DELTA);
        System.out.println("Même question si X suit une loi exponentielle.");
        ExponentialLaw exponentialLaw = new ExponentialLaw(1./moy);
        System.out.println("Rappel : Moyenne = 1/lambda");
        assertEquals(moy,exponentialLaw.getEsperance(), Calculation.DELTA);
        double resExp = exponentialLaw.F( 20);
        assertEquals(0.8647, resExp,Calculation.DELTA);
        System.out.println("res = " + resExp);

        System.out.println("Même question si X suit une loi uniforme.");
        System.out.println("Rappel : Moyenne = (inf+supp)/2");

        double inf=0;
        double supp=20;
        UniformLaw ulaw = new UniformLaw(inf,supp);
        assertEquals(moy, ulaw.getEsperance(), Calculation.DELTA );
        double resUni = ulaw.F( 20);
        assertEquals(1,resUni, Calculation.DELTA);
        System.out.println("res = " + resUni);

    }

    @Test
    public void ex4() throws CalculationException {

        System.out.println("\nExercice 4");
        System.out.println("Trouvez la meilleure borne pour P(X>10) : ");
        double resA=0,resB=0,resC=0,resD=0;
        System.out.println("E(X) = 3 & X>0");
        resA = Markov.P_x_sup_a_y_inferieur_a(3., 10);
        System.out.println("E(X) = 7 & X>6");
        resB = Markov.P_x_sup_a_y_inferieur_a(7.-6., 10.-6.);
        System.out.println("E(X) = 2 & X>-5");
        resC = Markov.P_x_sup_a_y_inferieur_a(2.+5, 15);
        System.out.println("E(X) = 5 & X>-10");
        resD = Markov.P_x_sup_a_y_inferieur_a(5+10, 20);

        assertEquals(0.3, resA, Calculation.DELTA);
        assertEquals(0.25, resB, Calculation.DELTA);
        assertEquals(7./15., resC, Calculation.DELTA);
        assertEquals(15./20., resD, Calculation.DELTA);

    }

    @Test
    public void ex5() throws CalculationException {

        System.out.println("\nExercice 5");
        String consigne = "Soit une variable aléartoire d'espérence E(X)=0" +
                "\ntelle que P(-3<X<2)=1/2"+
                "\na) Trouvez une borne inférieure pour V(X)"+
                "\nb) Trouvez V(X) si X suit une loi uniforme";
        System.out.println("a) \n -on sait que P(-3<X<2) < P(-2<X<2)" +
                "\net p(|x|<2)=1-(P(|X|>2)<1/2, on ne peut pas appliquer l'inégalité de markov car X est d'esperance nulle." +
                "\nOn peut appliquer Tchbichev P( |X-E(X)| > t ) < V(X) / (t^2) avec t = 1/2 et E(X) = 0 :" +
                "\ncomme P(|x-0|<2)<P(-3<X<2)  on obtient  P(|x-0|<2) < 1/2");
       double res = 0;
       res = Tchebychev.inequality(2.,2.);
       System.out.println("Pour une variance >= 2, P(|x-0|<2)=2/2*2 = "+res+">= 1/2");
       assertEquals(1/2., res, Calculation.DELTA);

        System.out.println("b) Si X suit une loi uniforme comme P(-3<X<2)=1/2" +
                "\nSur 5 valeurs on vaut 1/2, il faut 10 valeurs pour un d'ou :" );
        UniformLaw law = new UniformLaw(-5,5);
        double esp = law.getEsperance();
        double var = law.getVariance();
        assertEquals(0, esp, Calculation.DELTA);
        assertEquals(8.33, var, 0.01);

    }

    @Test
    public void ex6() throws CalculationException {

        System.out.println("\nExercice 6");
        String consigne = "On lance un dé 100 fois et on fait la somme S des résultats." +
                "\nQue peut-on dire de P(|S-350|>50 ? ";
        System.out.println("E(S) vaut 100*E(Dé)= 100*3.5");
        System.out.println("Calculons la variance");
        //TODO ASK
        double variance = 100*(7*5)/(2*6) ;//WHY ??
        System.out.println("variance = " + variance);
        double res = Tchebychev.inequality(variance,50);
        System.out.println("res = Tchebychev.inequality(variance,50);");
        assertEquals(7./60., res, 0.001);
        System.out.println("par le tcl, S suit une loi normale avec u = 350 et ecart_type = racine(100*(7*5)/(2*6))= "+ Math.sqrt(100*(7*5)/(2*6)));
        NormaleLaw normaleLaw = new NormaleLaw(350, Math.sqrt(291));
        res = normaleLaw.F(-400,300);
        assertEquals(0.3415, res, Calculation.DELTA);

        assertFalse(true);

    }

}
import Exceptions.CalculationException;
import Laws.ExponentialLaw;
import Laws.NormaleCenteredReducedLaw;
import Laws.NormaleLaw;
import Laws.UniformLaw;
import Properties.Markov;
import Properties.Tchebychev;
import org.junit.Test;
import tools.Calculation;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

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
        double res = Markov.P_x_inferieur_a_y(moy, 20);
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

}
package TD4_MIAGE;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.BernouilliLaw;
import Laws.BinomialeLaw;
import Laws.GeometricLaw;
import Laws.UniformLaw;
import tools.Calculation;
import tools.Displayable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TD4S6_exercice1 implements Displayable{
    @Test
    public void exercice1_a(){
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        UniformLaw uniformLaw = new UniformLaw(1, 16);
        System.out.println("E=1/(supp-inf)="+uniformLaw.f(5)+closure);
        assertEquals(1./(16.), uniformLaw.f(5), 0.00001);
    }

    @Test
    public void exercice1_b() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        BernouilliLaw bernouilliLaw = new BernouilliLaw(0.25);

        System.out.println("Loi de bernouilli : [0; 1] => 5 ne peut jamais être atteint !");
        System.out.println("E[X]="+bernouilliLaw.getEsperance()+closure);
        System.out.println("V[X]="+bernouilliLaw.getVariance()+closure);

        assertEquals(3./16., bernouilliLaw.getVariance(), 0.0001);
        //explications
        /**
         * On est en présence d’une loi de Bernouilli ici : X ne peut donc prendre pour valeurs que
         0 ou 1, donc 5 ne peut jamais être atteint. De plus, son paramètre vaut p = 1/4.
         */
        assertEquals(0., bernouilliLaw.getProbabiliteDeX(5), 0.01);
        System.out.println(closure);

    }
    @Test
    public void exercice1_c() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        System.out.println("X suit une loi binomiale B(8, 1./3.)");
        BinomialeLaw b = new BinomialeLaw( 1./3., 8);
        double probaE = b.getProbabiliteDeX(5);
        double espB = b.getEsperance();
        double varB = b.getVariance();
        //correction
        assertEquals(Calculation.kParmisN(5, 8)*(Math.pow(2,3)/Math.pow(3,8)),probaE, 0.0001);
        assertEquals(8./3.,espB, 0.0001);
        assertEquals(16./9.,varB, 0.0001);

        System.out.println("probaE = " + probaE);
        System.out.println("espB = " + espB);
        System.out.println("varB = " + varB);
        System.out.println(closure);

    }


    @Test
    public void exercice1_d() throws LawException, CalculationException {
        System.out.println(title_prefix + this.getClass().getSimpleName());
        System.out.println("Soit E = P(X=5)");
        System.out.println("X suit une loi géométrique g de paramètre 1./5.");

        GeometricLaw g = new GeometricLaw(1./5.);

        double probaE = g.getProbabiliteDeX(5);
        double espG = g.getEsperance();
        double varG = g.getVariance();

        assertEquals(256./Math.pow(5, 5),probaE, 0.0001);
        assertEquals(1./(1./5.),espG, 0.0001);
        assertEquals((1. - 1./5.)/Math.pow(1./5.,2),varG, 0.0001);


        System.out.println("probaE = " + probaE);
        System.out.println("espG = " + espG);
        System.out.println("varG = " + varG);
        System.out.println(closure);

    }
}
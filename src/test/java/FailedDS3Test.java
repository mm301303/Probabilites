import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.*;
import Properties.Markov;
import Properties.Tchebychev;
import org.junit.Before;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * approximation are really bad due to a minimalist implementation of mathematical models...
 */
public class FailedDS3Test {
    double res;
    @Before
    public void separator(){
        System.out.println("]=[]=[]=[]=[]=[]=[]=[]=[]=[]=[]=[]=[]=[");
        res =0;
    }

    @Test
    public void ex1() throws CalculationException {
        System.out.println("ENONCE :\n" +
                "La taille des hommes en Syldavie suit une loi normale : u = 180, ecart type s = 5 (cm)\n"+
                "Le corps d'élite de l'armée est composé d'hommes de cette population a condition que leur taille soir >=185cm\n"+
                "Quelle est la proportion d'hommes du corps d'élite de taille >= 190cm?\n");

        //on essaie avec la NCR
        NormaleCenteredReducedLaw taille_syldavie = new NormaleCenteredReducedLaw();
        //La question est parmis les hommes de taille >= 185 quelle proportion sont >= 190
        double F_185 = taille_syldavie.F((185.-180.)/5.); //sur sigma
        double F_190 = taille_syldavie.F((190.-180.)/5.);
        res = F_190-F_185;
        assertEquals(0.143393, res, Calculation.DELTA );
    }

    @Test
    public void ex2() throws CalculationException, LawException {
        System.out.println("ENONCE :\n" +
                "La duree de vie d'une ampoule LeD suit une loi exponentielle de moyenne 11000 h\n"+
                "Vous achetez 4 ampoules\n"+
                "Quelle est la proba d'avoir exactement une ampoule morte au bout de 11000h?\n");
        ExponentialLaw exponentialLaw = new ExponentialLaw(11000);
        BinomialeLaw binomialeLaw = new BinomialeLaw(exponentialLaw.getEsperance(),11000);
        //TODO ask
        res = binomialeLaw.getProbabiliteDeX(0)*Calculation.kParmisN(3,4)*binomialeLaw.getProbabiliteDeX(1)*Calculation.kParmisN(1,4);
        assertEquals(0.1259, res, Calculation.DELTA );
    }
    @Test
    public void ex3() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(0.950213, res, Calculation.DELTA );
    }
    @Test
    public void ex4() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(0.2946, res, Calculation.DELTA );
    }
    @Test
    public void ex5() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(40./9., res, Calculation.DELTA );
    }
    @Test
    public void ex6() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(406./899., res, Calculation.DELTA );

    }
    @Test
    public void ex7() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(1.4608, res, Calculation.DELTA );
    }
    @Test
    public void ex8() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(570., res, Calculation.DELTA );
    }
    @Test
    public void ex9() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        System.out.println("Aucun de ces évenements ne sont indépendants !");
    }

    @Test
    public void ex10() {
        System.out.println("ENONCE :\n" +
                ""+"\n"+"\n"+"\n"+"\n"+"\n");
        assertEquals(0.002737, res, Calculation.DELTA );

    }



}
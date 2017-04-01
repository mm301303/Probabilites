import Exceptions.CalculationException;
import Laws.ExponentialLaw;
import Laws.NormaleLaw;
import Laws.UniformLaw;
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
    public void ex1() {
        assertEquals(0.143393, res, Calculation.DELTA );
    }

    @Test
    public void ex2() {
        assertEquals(0.1259, res, Calculation.DELTA );
    }
    @Test
    public void ex3() {
        assertEquals(0.950213, res, Calculation.DELTA );
    }
    @Test
    public void ex4() {
        assertEquals(0.2946, res, Calculation.DELTA );
    }
    @Test
    public void ex5() {
        assertEquals(40./9., res, Calculation.DELTA );
    }
    @Test
    public void ex6() {
        assertEquals(406./899., res, Calculation.DELTA );

    }
    @Test
    public void ex7() {
        assertEquals(1.4608, res, Calculation.DELTA );
    }
    @Test
    public void ex8() {
        assertEquals(570., res, Calculation.DELTA );
    }
    @Test
    public void ex9() {
        System.out.println("Aucun de ces évenements ne sont indépendants !");
    }

    @Test
    public void ex10() {
        assertEquals(0.002737, res, Calculation.DELTA );

    }



}
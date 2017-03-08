package tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maxime on 07/03/17.
 */
public class CalculationsTest {
    @Test
    public void coef_binomial() throws Exception {

        assertEquals(100,Calculations.coef_binomial(1, 100),0.001);
    }

    @Test
    public void factorielle() throws Exception {

    }

}
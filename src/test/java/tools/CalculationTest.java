package tools;

import Exceptions.CalculationException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 09/03/17.
 */
public class CalculationTest {
    double delta = 0.01;
    @Test
    public void factorielle() throws Exception {
        try{
            assertEquals(1,Calculation.factorielle(0),delta);
            assertEquals(2,Calculation.factorielle(2),delta);
            assertEquals(1,Calculation.factorielle(1),delta);
            assertEquals(6,Calculation.factorielle(3),delta);
            assertEquals(362880,Calculation.factorielle(9),delta);

        }catch (CalculationException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void kParmisN() throws Exception {
        try{
            assertEquals(36,Calculation.kParmisN(1,36),delta);
            assertEquals(1,Calculation.kParmisN(36,36),delta);
            assertEquals(906192.,Calculation.kParmisN(6,32),delta);


        }catch (CalculationException e){
            System.out.println(e.getMessage());
        }
    }

}
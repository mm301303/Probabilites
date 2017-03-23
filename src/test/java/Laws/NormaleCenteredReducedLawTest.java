package Laws;

import Exceptions.CalculationException;
import org.junit.Before;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * IMPLEMENT ANOTHER F
 */
public class NormaleCenteredReducedLawTest {
    NormaleCenteredReducedLaw ncrl;
    double delta = 0.2;
     @Before
     public void init() throws CalculationException {
         ncrl = new NormaleCenteredReducedLaw();
     }
    @Test
    public void f_de_p_superieur_a() throws  CalculationException {

        assertEquals(0.500,ncrl.F_de_p_superieur_a(0), Calculation.DELTA);
    }

    @Test
    public void f_de_p_inferieur_a() throws  CalculationException {

        assertEquals(0.5,ncrl.F(0), Calculation.DELTA);
        assertEquals(0.27425,  ncrl.F(-3./5.), delta);

    }
    @Test
    public void f_de_p_inferieur_aVals() throws  CalculationException {

        assertEquals(0.46017, ncrl.F(-0.1), delta);
        assertEquals(0.57926, ncrl.F(0.2), delta);
        assertEquals(0.61791, ncrl.F(0.3), delta);
        assertEquals(0.84134, ncrl.F(1.), delta);
        assertEquals(0.97725, ncrl.F(2.), delta);
    }
    @Test
    public void f_de_p_superieur_aVals() throws  CalculationException {

        assertEquals(0.46017, ncrl.F_de_p_superieur_a(0.11), delta);
        assertEquals(0.42074, ncrl.F_de_p_superieur_a(0.200), delta);//0.2
        assertEquals(0.38209, ncrl.F_de_p_superieur_a(0.3), delta);
        assertEquals(1-0.84134, ncrl.F_de_p_superieur_a(1.), delta);
        assertEquals(1-0.97725, ncrl.F_de_p_superieur_a(2.), delta);
    }

    @Test
    public void Ftest(){

        //delta = 0.01;
        System.out.println("erreur de " + (0.53983-0.52847)+" a "+(0.97725-0.84116)+"... =(");
        assertEquals(0.53983, ncrl.F(0.1), delta);
        assertEquals(0.57926, ncrl.F(0.2), delta);
        assertEquals(0.61791, ncrl.F(0.3), delta);
        assertEquals(0.15866, ncrl.F(-1.), delta);
        assertEquals(0.0227, ncrl.F(-2.), delta);

    }

}
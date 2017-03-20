package Laws;

import Exceptions.CalculationException;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by max on 20/03/17.
 */
public class NormaleCenteredReducedLawTest {

    @Test
    public void f_de_p_superieur_a() throws Exception, CalculationException {
        NormaleCenteredReducedLaw ncrl = new NormaleCenteredReducedLaw();
        assertEquals(0.5,ncrl.F_de_p_inferieur_a(0), Calculation.DELTA);
    }

    @Test
    public void f_de_p_inferieur_a() throws Exception {

    }

}
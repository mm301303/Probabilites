package Laws;

import Laws.PoissonLaw;
import Laws.functions.Law;
import org.junit.Before;
import org.junit.Test;
import tools.Calculation;

import static org.junit.Assert.*;

/**
 * Created by maxime on 06/03/17.
 */
public class PoissonLawTest {
    private double delta= Calculation.DELTA;
    private PoissonLaw poisson;
    double lambda;


    @Test
    public void getName() throws Exception {
        poisson = new PoissonLaw(5.);
        assertEquals("Poisson Laws.functions.Law", poisson.getName());
    }

}
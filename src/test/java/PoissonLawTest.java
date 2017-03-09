import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maxime on 06/03/17.
 */
public class PoissonLawTest {
    private Law poisson;
    double lambda = 3;
    @Before
    public void init(){
        this.poisson = new PoissonLaw(lambda);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Poisson Law", poisson.getName());
    }

}
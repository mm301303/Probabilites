import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maxime on 02/03/17.
 */
public class GeometricLawTest {
    @Test
    public void exoTest() throws Exception {
        double psucess = 0.5;
        int nb = 30;

        GeometricLaw geoLaw = new GeometricLaw(psucess, nb);
        geoLaw.display(psucess, nb, 4);
    }

}
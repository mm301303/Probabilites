import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by maxime on 02/03/17.
 */
public class GeometricLawTest {
    @Test
    public void Question2DS1Test() throws Exception {
        double psucess = 1./9.;
        int nb = 100;
        int i=0;

        GeometricLaw geoLaw = new GeometricLaw(psucess, nb);
        ArrayList<Double> geoResults = geoLaw.compute();
        double p = 0;
        while(p<0.6){
            p+=geoResults.get(i);
            i++;
        }
        System.out.println("Res = " + (int)(i-1));
    }

}
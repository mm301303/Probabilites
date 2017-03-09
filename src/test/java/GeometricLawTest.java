import Exceptions.LawException;
import Laws.GeometricLaw;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by maxime on 02/03/17.
 */
public class GeometricLawTest {
    @Test
    public void Question2DS1Test() throws Exception {
        double psucess = 1./9.;
        int nb = 100;
        int i=0;

        GeometricLaw geoLaw = null;
        try {
            geoLaw = new GeometricLaw(psucess, nb);
        } catch (LawException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        ArrayList<Double> geoResults = new ArrayList<>();
        double p = 0;
        while(p<0.6){
            p += geoLaw.getProbabiliteDeX(i);
            i++;
        }
        System.out.println("Res = " + (int)(i-1));
    }

}
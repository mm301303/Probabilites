import org.apache.commons.math3.analysis.UnivariateFunction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 07/03/17.
 */
public class UniformLawTest {

    @Test
    public void exo1TD1(){
        double borneInfU = 0;
        double borneSuppU = 30;

        UniformLaw uniformLaw = new UniformLaw(borneInfU, borneSuppU);

        System.out.println("Attendre moins de 5 min :");
        Displayable.displayContinuousLaw(uniformLaw,10,15);
        Displayable.displayContinuousLaw(uniformLaw,25,30);
    }
}
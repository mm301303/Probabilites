import Exceptions.CalculationException;

import java.util.ArrayList;

/**
 * Created by maxime on 02/03/17.
 */
public interface Law {
     String getName();
     String getParameters();
     double getProbabiliteDeX(int x_egal_i) throws CalculationException;
     double getEsperance();
     double getVariance();
}

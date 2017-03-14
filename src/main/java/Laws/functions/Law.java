package Laws.functions;

import Exceptions.CalculationException;

/**
 * Created by maxime on 02/03/17.
 */
public interface Law {
     String getName();
     String getParameters();
     double getProbabiliteDeX(double x_egal_i) throws CalculationException;
     double getEsperance();
     double getVariance();
}

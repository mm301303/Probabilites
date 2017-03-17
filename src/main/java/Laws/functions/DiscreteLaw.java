package Laws.functions;

import Exceptions.CalculationException;

/**
 * Created by max on 17/03/17.
 */
public interface DiscreteLaw {
    double getProbabiliteDeX(double x_egal_i) throws CalculationException;
}

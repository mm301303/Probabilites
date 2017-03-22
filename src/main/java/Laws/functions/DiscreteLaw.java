package Laws.functions;

import Exceptions.CalculationException;

/**
 * Created by max on 17/03/17.
 */
public interface DiscreteLaw {
    double getProbabiliteDeX(int x_egal_i) throws CalculationException;
}

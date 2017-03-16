package Laws;

import Exceptions.CalculationException;
import Laws.functions.Law;
import tools.Displayable;

/**
 * Created by maxime on 16/03/17.
 */
public class NormaleLaw implements Law, Displayable {
    @Override
    public String getName() {
        return "Normale law must be applied on universe";
    }

    @Override
    public String display() {
        return null;
    }

    @Override
    public String getParameters() {
        return null;
    }

    @Override
    public double getProbabiliteDeX(double x_egal_i) throws CalculationException {
        return 0;
    }

    @Override
    public double getEsperance() {
        return 0;
    }

    @Override
    public double getVariance() {
        return 0;
    }
}

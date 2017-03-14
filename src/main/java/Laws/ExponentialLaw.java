package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;

/**
 * Created by max on 14/03/17.
 */
public class ExponentialLaw implements Law, ContinuousLaw, Displayable {
    private double lambda;


    public ExponentialLaw(double lambda){
        this.lambda=lambda;
    }

    @Override
    public String getName() {
        return "Exponential Law";
    }

    @Override
    public String display() {
        return getName()+" ; "+getParameters();
    }

    @Override
    public String getParameters() {
        return "Lambda = "+lambda;
    }

    @Override
    public double getProbabiliteDeX(double x_egal_i) throws CalculationException {
        Double res = lambda*Math.exp(-lambda*x_egal_i);
        return res;
    }

    @Override
    public double getEsperance() {
        return 1./lambda;
    }

    @Override
    public double getVariance() {
        return 1./Math.pow(lambda,2);
    }

    @Override
    public double density(double a, double b) {
        double x, res;
        if(a<0&&b<0) return 0;
        if(a<0) return density(0, b);

        try {
            return  getProbabiliteDeX(a) - getProbabiliteDeX(b);
        } catch (CalculationException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

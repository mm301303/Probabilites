import org.apache.commons.math3.analysis.UnivariateFunction;

/**
 * Created by maxime on 07/03/17.
 */
public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private UnivariateFunction f;
    private static final int MAX_EVAL=15;

    public void setFunction(UnivariateFunction f) {
        this.f = f;
    }

    @Override
    public double density(double a, double b) {
        if(a==b) return 0.;
        else return integrale(a,b, f);
    }

    private double integrale(double a, double b) {
            (MAX_EVAL,a,b, f);
    }

    @Override
    public double compute(int x_egal_i) {
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getParameters() {
        return null;
    }
}

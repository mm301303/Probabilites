import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;


public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private final double supp;
    private final double inf;
    private UnivariateFunction f;
    private static final int MAX_EVAL=10;
    SimpsonIntegrator baseAbstractUnivariateIntegrator;

    public UniformLaw(double inf, double supp) {
        baseAbstractUnivariateIntegrator = new SimpsonIntegrator();
        this.inf = inf;
        this.supp = supp;
        this.f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x/(supp-inf);
            }
        };

    }

    @Override
    public double density(double a, double b) {
        if(a==b) return 0.;
        else return baseAbstractUnivariateIntegrator.integrate(MAX_EVAL,f,a,b);
        //return f.value(b) - f.value(a);
    }

    @Override
    public double compute(int x_egal_i) {
        return 0;//property
    }

    @Override
    public double getEsperance() {
        return (inf+supp)/2;
    }

    @Override
    public double getVariance() {
        return (supp-inf)*(supp-inf)/(supp-inf);
    }

    @Override
    public String getName() {
        return " Uniform Law ";
    }

    @Override
    public String getParameters() {
        return f.toString();
    }
}

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;


public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private double supp;
    private double inf;
    private UnivariateFunction DENSITY;

    private static final int MAX_EVAL=10;
    //SimpsonIntegrator baseAbstractUnivariateIntegrator;

    public UniformLaw(double inf, double supp) {
        //baseAbstractUnivariateIntegrator = new SimpsonIntegrator();
        this.inf = inf;
        this.supp = supp;
        DENSITY = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x-inf)/(supp-inf);
            }
        };
    }

    @Override
    public double density(double a, double b) {

        if(a>=b) return 0.;
        else
            return Math.abs(DENSITY.value(b) - DENSITY.value(a));
    }

    @Override
    public double getEsperance() {

        return (inf+supp)/2;
    }

    @Override
    public double getVariance() {
        double base = 12;
        double num = Math.pow(supp-inf, 2);

        return num/base;
    }

    @Override
    public String getName() {

        return " Uniform Law ";
    }

    @Override
    public String getParameters() {
        return "borne inf:"+inf+"; borne supp:"+supp;

    }

    @Override
    public double getProbabiliteDeX(int x_egal_i) {

        return 0;//property
    }
}

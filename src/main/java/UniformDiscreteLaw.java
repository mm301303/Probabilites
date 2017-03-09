import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;


public class UniformDiscreteLaw implements Law, Displayable {
    private final double supp;
    private final double inf;
    private static final int MAX_EVAL=10;

    public UniformDiscreteLaw(double inf, double supp) {
        this.inf = inf;
        this.supp = supp;


    }

    public double density(double a, double b) {
        if(a==b) return 0.;
        return 0;
    }

    @Override
    public double getProbabiliteDeX(int x_egal_i) {

        display();//for debug
        return 1/(supp-inf+1);//property
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
    public String display() {
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return this.getClass().getSimpleName();
    }
}

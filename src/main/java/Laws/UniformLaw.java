package Laws;

import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import org.apache.commons.math3.analysis.UnivariateFunction;
import tools.Displayable;


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

        return "Uniform Laws.functions.Law ";
    }

    @Override
    public String display() {

        display();//for debug
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
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

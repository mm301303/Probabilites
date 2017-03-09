package Laws;

import Laws.functions.Law;
import tools.Displayable;


public class UniformDiscreteLaw implements Law, Displayable {
    private final double supp;
    private final double inf;
    private int n;

    private static final int MAX_EVAL=10;

    public UniformDiscreteLaw(int inf, int supp) {
        this.inf = inf;
        this.supp = supp;
        n = 1 + supp - inf;

    }

    public double density(int X) {
        if(X<inf) return 0.;
        if(X>supp) return 1;
        return (X-inf+1)/n;
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
        return " Uniform Laws.functions.Law ";
    }

    @Override
    public String display() {
        return Displayable.title_prefix+getName()+ Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return this.getClass().getSimpleName();
    }
}

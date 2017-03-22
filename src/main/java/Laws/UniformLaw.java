package Laws;

import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;


public class UniformLaw implements Law, ContinuousLaw, Displayable {
    private double supp;
    private double inf;

    private static final int MAX_EVAL=10;

    public UniformLaw(double inf, double supp) {
        this.inf = inf;
        this.supp = supp;

    }

    public double f(double a, double b) {
        return f(b) - f(a);
    }

    @Override
    public double f(double a) {
        return 1/(supp-inf);
    }

    public double F(double x_inferieur_a_y) {
        if(x_inferieur_a_y>=supp) return 1;
        if(x_inferieur_a_y<=inf) return 0;
        return (x_inferieur_a_y-inf)/(supp-inf);
    }

    @Override
    public double F_de_p_superieur_a(double b) {
        if(supp-b>0) return 1-F(b);
        return -1;
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

}

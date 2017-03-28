package Laws;

import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Calculation;
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
    public double getEsperance() {
        return 1./lambda;
    }

    @Override
    public double getVariance() {
        return 1./Math.pow(lambda,2);
    }

    public double f(double a, double b) {
        double x, res;
        if(a<0&&b<0) return 0;
        return  f(a) - f(b);
    }

    @Override
    public double f(double a) {
        if(a<0) return 0;
        else return lambda*Math.exp(-lambda*a);
    }

    @Override
    public double F(double x_inferieur_a_y) {
        return Calculation.integraleParSimpson(0,x_inferieur_a_y,this);

    }

    public double F(double x_inferieur_a_y , double x_superieur_a_y){
        return F(x_superieur_a_y)-F(x_inferieur_a_y);
    }

    @Override
    public double F_de_p_superieur_a(double b) {
        return F(b);
    }


}

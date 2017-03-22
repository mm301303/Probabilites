package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Calculation;
import tools.Displayable;

/**
 * TODO implement DS
 */
public class NormaleCenteredReducedLaw implements Law, Displayable, ContinuousLaw {

    private NormaleCenteredReducedLaw normaleLaw;
    private double variance;
    private double esperance;

    public NormaleCenteredReducedLaw() throws CalculationException {
        this.esperance = 0;
        this.variance = 1;
    }

    public String getName() {
        return "NormaleCentreeReduite";
    }

    @Override
    public String display() {
        return getName() + "\n" + getParameters();
    }

    @Override
    public String getParameters() {
        return "variance = "+variance+ "esperance = "+esperance;
    }


    @Override
    public double getEsperance() {
        return esperance;
    }

    @Override
    public double getVariance() {
        return variance;
    }


    @Override
    public double f(double a) {
        return Math.exp(-0.5*Math.pow(((a-esperance)/ Math.sqrt(variance)), 2))/(variance+Math.pow(2*Math.PI, 0.5));
    }

    @Override
    public double F(double x_inferieur_a_y) {
        double integrale = Calculation.integraleParSimpson(0,x_inferieur_a_y,this);
        return integrale;
    }


    public double F_de_p_superieur_a(double b){
        return F(-b);
    }

}

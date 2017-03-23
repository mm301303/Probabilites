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
    public double F(double b) {
        if(b==0.) return 0.5;
        double integrale;
        if(b>0)
         integrale = 0.5+Calculation.integraleParSimpson(esperance, b,this);
        else
         integrale = 0.5-Calculation.integraleParSimpson(esperance, -b, this);
        return integrale;
    }


    public double F_de_p_superieur_a(double b){
        return F(-b);
    }

}

package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.StrictMath.sqrt;

/**
 * TODO implement DS
 */
public class NormaleLaw implements Law, Displayable, ContinuousLaw {

    private NormaleLaw normaleLaw;
    private double variance;
    private double esperance;

    public NormaleLaw(double esperance, double variance){
        this.esperance = esperance;
        this.variance = variance;
    }

    public String getName() {
        return "Normale law must be applied on universe";
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
    public double density(double a, double b) {
        return density(max(a,b)) - density(min(a,b));
    }

    @Override
    public double density(double a) {
        return Math.pow(2*Math.PI*variance, -0.5)*Math.exp(-0.5*Math.pow(((a-esperance)/sqrt(variance)), 2));
    }


}

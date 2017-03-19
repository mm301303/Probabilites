package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Calculation;
import tools.Displayable;

import javax.swing.text.MutableAttributeSet;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.StrictMath.sqrt;
import static tools.Calculation.approximationDintegrale;

/**
 * TODO implement DS
 */
public class NormaleLaw implements Law, Displayable, ContinuousLaw {

    private NormaleLaw normaleLaw;
    private double variance;
    private double esperance;

    public NormaleLaw(double esperance, double variance) throws CalculationException {
        this.esperance = esperance;
        if(variance<0) throw new CalculationException(variance);
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
        return approximationDintegrale(max(a,b), min(a,b) , this);
    }

    @Override
    public double density(double a) {
        return Math.exp(-0.5*Math.pow(((a-esperance)/ Math.sqrt(variance)), 2)))/(variance+Math.pow(2*Math.PI, 0.5);
    }

    double F(double x){
        return 1−density(x)(b1*t+b2*Math.pow(t,2)+b3t3+b4t4+b5t5)+o(x5)
    }



}

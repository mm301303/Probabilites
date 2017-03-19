package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;

import static java.lang.Math.max;
import static java.lang.Math.min;
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
    public double f(double a, double b) {
        return approximationDintegrale(max(a,b), min(a,b) , this);
    }

    @Override
    public double f(double a) {
        return Math.exp(-0.5*Math.pow(((a-esperance)/ Math.sqrt(variance)), 2))/(variance+Math.pow(2*Math.PI, 0.5));
    }

    double F(double x_inferieur_a_y , double x_superieur_a_y){
        int nb_points=100000;
        double dx = esperance/nb_points;
        double surface =0;
        double i;
        //la fonction est paire
        if(x_inferieur_a_y<esperance) return F(esperance,Math.abs(x_inferieur_a_y))+F(esperance,x_superieur_a_y);
        for(i=x_inferieur_a_y; i<x_superieur_a_y; i+=dx)
        {
            surface+=f(i)*dx;
        }
        return surface;
    }



}

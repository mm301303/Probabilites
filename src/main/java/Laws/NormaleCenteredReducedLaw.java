package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
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


    public double F(double x_inferieur_a_y , double x_superieur_a_y){
        int nb_points=1000;
        double dx = 1./nb_points;
        double surface =0;
        double i;
        //la fonction est paire
        for(i=x_inferieur_a_y; i<x_superieur_a_y; i+=dx)
        {
            surface+=f(i)*dx;
        }
        return surface;
    }


    public double F_de_p_superieur_a(double b){
        System.out.println("b = " +b+"->"+ F(0,b));
        if(b>=0) return 0.5 - F(0.,b);
        else return 0.5 + F(b, 0.);
    }

    public double F_de_p_inferieur_a(double b) {
        if(b>=0) return 1./2.+F(0,b);
        else return 1/2 - F(b, 0);
    }


}

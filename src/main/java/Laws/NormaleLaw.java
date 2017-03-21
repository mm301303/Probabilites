package Laws;

import Exceptions.CalculationException;
import Laws.functions.ContinuousLaw;
import Laws.functions.Law;
import tools.Displayable;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;
import static tools.Calculation.approximationDintegrale;

/**
 * Christophe Papazian [8:02 AM] 
 * Il est important de comprendre que le résultat ne dépend ni de l'espérance, ni de l'écart-type.
 * En particulier, cela donne une bonne idée de la répartition connaissant la moyenne et l'écart-type 
 * d'une loi normale : on a environ 2 chances sur 3 d'être à moins d'un écart-type de l'espérance.
*/
public class NormaleLaw extends NormaleCenteredReducedLaw implements Law, Displayable, ContinuousLaw {

    private NormaleLaw normaleLaw;
    private double variance;
    private double esperance;

    public NormaleLaw(double esperance, double variance) throws CalculationException {
        super();
        this.variance = variance;
        this.esperance = esperance;
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
    public double f(double a) {
        return super.f(a);
    }

    @Override
    public double F(double a, double b){
        return super.F((a-esperance)/sqrt(variance), (b-esperance)/sqrt(variance));
    }


    public double F_de_p_superieur_a(double b){
        double ncrBorne = b-esperance/sqrt(variance);
        if(b>0) return 1-super.F(0,ncrBorne);
        else return 1/2 + super.F(ncrBorne, 0);
    }

    @Override
    public double  F_de_p_inferieur_a(double b){
        return super.F_de_p_inferieur_a((b-esperance)/sqrt(variance));
    }
}

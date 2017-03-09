import Exceptions.LawException;

import java.util.ArrayList;

/**
 * Displayable Law for geometricLaw
 */
public class GeometricLaw implements Law, Displayable{

    private double proba_reussite;
    private boolean ok=false;//enable calculation
    private ArrayList<Double> memoisation;

    public GeometricLaw(double probabilite, int i) throws LawException {
        proba_reussite = probabilite;
        if(!(probabilite<1||probabilite>0)){
            throw new LawException(this.getClass(), "probabilite"+probabilite);
        }
    }

    @Override
    public double compute(int x_egal_i) {
        return Math.pow(1.-proba_reussite, x_egal_i-1)*proba_reussite;
    }

    public double getEsperance(){
        if(!ok) return -1;
        return 1/proba_reussite;
    }

    @Override
    public double getVariance() {
        if(!ok) return -1;
        return (1-proba_reussite)/(proba_reussite*proba_reussite);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getParameters() {
        return "pSuccess = "+proba_reussite ;
    }

}

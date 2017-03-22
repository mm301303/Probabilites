package Laws;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.functions.DiscreteLaw;
import Laws.functions.Law;
import tools.Displayable;

public class GeometricLaw implements Law, Displayable, DiscreteLaw {

    private double proba_reussite;

    public GeometricLaw(double probabilite) throws LawException {
        proba_reussite = probabilite;
        if(!(probabilite<1||probabilite>0)){
            throw new LawException(this.getClass(), "probabilite"+probabilite);
        }
    }


    public double getProbabiliteDeX(double x_egal_i) {
        return Math.pow(1.-proba_reussite, x_egal_i-1.)*proba_reussite;
    }

    public double getEsperance(){
        return 1/proba_reussite;
    }

    @Override
    public double getVariance() {
        return (1-proba_reussite)/(proba_reussite*proba_reussite);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String display() {
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "pSuccess = "+proba_reussite ;
    }

    @Override
    public double getProbabiliteDeX(int x_egal_i) throws CalculationException {
        return Math.pow(1.-proba_reussite, x_egal_i-1.)*proba_reussite;
    }
}

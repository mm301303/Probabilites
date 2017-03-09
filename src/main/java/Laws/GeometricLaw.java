package Laws;

import Exceptions.LawException;
import Laws.functions.Law;
import tools.Displayable;

import java.util.ArrayList;

public class GeometricLaw implements Law, Displayable {

    private double proba_reussite;

    public GeometricLaw(double probabilite) throws LawException {
        proba_reussite = probabilite;
        if(!(probabilite<1||probabilite>0)){
            throw new LawException(this.getClass(), "probabilite"+probabilite);
        }
    }

    @Override
    public double getProbabiliteDeX(int x_egal_i) {
        display();//for debug
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

}

package Laws;

import Exceptions.CalculationException;
import Exceptions.LawException;
import Laws.functions.DiscreteLaw;
import Laws.functions.Law;
import tools.Calculation;
import tools.Displayable;

/**
 * Created by maxime on 09/03/17.
 */
public class BinomialeLaw implements Law, Displayable, DiscreteLaw {
    private double p;
    private int n;
    public BinomialeLaw(double p,int n) throws LawException {
        this.p = p;
        this.n = n;
        if(!(p>0 && p<1 && n>0)) throw new LawException("Invalid parameters p="+p+" n="+n);
    }


    public double getProbabiliteDeX(int x_egal_i) throws CalculationException {
        //System.out.println(display());//for debug
        return Calculation.kParmisN(x_egal_i, n) * Math.pow(p,x_egal_i) * Math.pow((1.- p) , n-x_egal_i);
    }

    @Override
    public double getEsperance() {
        return n*p;
    }

    @Override
    public double getVariance() {
        return n*p*(1-p);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String display() {
        return Displayable.title_prefix+getName()+ Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "B(n="+n+" p="+p+")";
    }
}

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
    public BinomialeLaw(int n, double p) throws LawException {
        this.p = p;
        this.n = n;
        if(!(p>0 && p<1 && n>0)) throw new LawException("Invalid parameters p="+p+" n="+n);
    }


    public double getProbabiliteDeX(int k) throws CalculationException {
        Law.printcalcul("P(X="+k+")", "k("+k+","+n+")*("+p+"^"+n+")*((1-"+p+")^("+n+"-"+k+"))="+( Calculation.kParmisN(k, n) * Math.pow(p,k) * Math.pow((1.- p) , n-k)) );
        return Calculation.kParmisN(k, n) * Math.pow(p,k) * Math.pow((1.- p) , n-k);
    }

    @Override
    public double getEsperance() {
        Law.printcalcul("E[X]", "n*p="+n+"*"+p);
        return n*p;
    }

    @Override
    public double getVariance() {
        Law.printcalcul("V[X]", "n*p*(1-p)="+n+"*"+p+"*(1-"+p+")");
        return n*p*(1-p);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String display() {
        return this.getName()+": "+getParameters();
    }

    @Override
    public String getParameters() {
        return "B(n="+n+" p="+p+")";
    }
}

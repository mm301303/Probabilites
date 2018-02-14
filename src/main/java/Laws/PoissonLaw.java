package Laws;

import Laws.functions.Law;
import tools.Calculation;
import tools.Displayable;

/**
 * c'est l'approximation d'une loi binomiale pour n grand et p petit
 */
public class PoissonLaw implements Law, Displayable {

    private double lambda;

    public PoissonLaw(double lambda){
        this.lambda = lambda;
    }

    public double getProbabiliteDeX(double x_egal_i){
        double coef = Math.exp(-lambda);
        int denom = 0;
        try {
            denom = (int)Calculation.factorielle((int)x_egal_i);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.printf("exiting -");
            System.exit(-1);
        }
        double numerateur = Math.pow(lambda, x_egal_i);
        double proba = coef*numerateur/denom;
        return proba;
    }

    @Override
    public double getEsperance() {
        return lambda;
    }

    @Override
    public double getVariance() {
        return lambda;
    }


    @Override
    public String getName() {
        return "Poisson Laws.functions.Law";
    }

    public String display() {
        return Displayable.title_prefix+getName()+Displayable.closure+"\n"+getParameters();
    }

    @Override
    public String getParameters() {
        return "lambda = " + lambda;
    }


}

import java.util.ArrayList;

/**
 * c'est l'approximation d'une loi binomiale pour n grand et p petit
 */
public class PoissonLaw implements Law, Displayable{

    private double lambda;

    public PoissonLaw(double lambda){
        this.lambda = lambda;
    }

    public double getProbabiliteDeX(int x_egal_i){
        double coef = Math.exp(-lambda);
        int denom = 0;
        try {
            denom = factorielle(x_egal_i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.printf("exiting -");
            System.exit(-1);
        }
        double numerateur = Math.pow(lambda, x_egal_i);
        double proba = coef*numerateur/denom;
        return proba;
    }

    /**
     * maybe existing somewhere else
     * @param n
     * @return
     */
    private int factorielle(int n) throws Exception{
        if(n<0) throw new Exception(this.getClass().getSimpleName()+" error: given arg is negative");//may cause error but at list result will be negative
        if(n>=1){
            int denominateur = 1;
            for(int i = 1; i< n; i++){
                denominateur*=i;
            }
            return denominateur;
        }else return 1;//fact(0) = 1
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
        return "Poisson Law";
    }

    @Override
    public String getParameters() {
        return "lambda = " + lambda;
    }


}

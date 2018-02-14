package Properties;

/**
 * Created by max on 28/03/17.
 */
public abstract class Tchebychev {
    /**
     * approxime a plus ou moins t autour de la moyenne
     * généralement de manière peu précise
     * Valable pour tout t>0, pour tout X une var aléatoire ayant une variance finie
     * @param var_x : La variance de la variable aléatoire
     * @param t : t tel que  P( |X-E(X)| > t ) < V(X) / (t^2)
     */
    public static double inequality(double var_x, double t){
        return var_x / (t*t);
    }
}

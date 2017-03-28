package Properties;

/**
 * Created by max on 28/03/17.
 */
public class Tchebychev {
    /**
     * approxime a plus ou moins t autour de la moyenne
     * @param x
     * @param var_x
     * @param t
     * @return
     */
    public static double inequality(double var_x, double t){
        return var_x*var_x/(t*t);
    }
}

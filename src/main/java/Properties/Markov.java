package Properties;

/**
 * Created by maxime on 28/03/17.
 */
public abstract class Markov {
    /**
     * Exprime P(X>=y)
     * Valable pour tout y>0, pour tout X une var aléatoire positive non nulle dont l'esperance existe
     * @param esp_x
     * @return P(x<y)<this
     */
    public static double P_x_sup_a_y_inferieur_a(double esp_x, double y){
        return esp_x/y;
    }

}

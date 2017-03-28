package Properties;

/**
 * Created by maxime on 28/03/17.
 */
public class Markov {
    /**
     *
     * @param esp_x
     * @return P(x<y)<this
     */
    public static double P_x_inferieur_a_y(double esp_x, double y){
        return esp_x/y;
    }
}
